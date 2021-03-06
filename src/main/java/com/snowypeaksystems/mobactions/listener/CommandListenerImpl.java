package com.snowypeaksystems.mobactions.listener;

import static com.snowypeaksystems.mobactions.util.Messages.gm;

import com.snowypeaksystems.mobactions.AbstractMobActions;
import com.snowypeaksystems.mobactions.command.CancelCommandImpl;
import com.snowypeaksystems.mobactions.command.CreateCommandImpl;
import com.snowypeaksystems.mobactions.command.DelWarpCommandImpl;
import com.snowypeaksystems.mobactions.command.EventCancelCommandImpl;
import com.snowypeaksystems.mobactions.command.EventCreateCommandImpl;
import com.snowypeaksystems.mobactions.command.EventForceStartCommandImpl;
import com.snowypeaksystems.mobactions.command.EventInfoCommandImpl;
import com.snowypeaksystems.mobactions.command.EventListCommandImpl;
import com.snowypeaksystems.mobactions.command.EventOpenCommandImpl;
import com.snowypeaksystems.mobactions.command.EventRemoveCommandImpl;
import com.snowypeaksystems.mobactions.command.ListWarpsCommandImpl;
import com.snowypeaksystems.mobactions.command.PlayerCommand;
import com.snowypeaksystems.mobactions.command.ReloadCommandImpl;
import com.snowypeaksystems.mobactions.command.RemoveCommandImpl;
import com.snowypeaksystems.mobactions.command.SetWarpCommandImpl;
import com.snowypeaksystems.mobactions.command.WarpCommandImpl;
import com.snowypeaksystems.mobactions.data.CommandDataImpl;
import com.snowypeaksystems.mobactions.data.EventDataImpl;
import com.snowypeaksystems.mobactions.data.MobData;
import com.snowypeaksystems.mobactions.data.WarpDataImpl;
import com.snowypeaksystems.mobactions.mobevent.MobEvent;
import com.snowypeaksystems.mobactions.player.MobActionsUser;
import com.snowypeaksystems.mobactions.player.PlayerException;
import com.snowypeaksystems.mobactions.util.DebugLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.util.StringUtil;

/**
 * Handles all command related information for the plugin.
 *
 * @author Copyright (c) Levi Muniz. All Rights Reserved.
 */
public class CommandListenerImpl implements CommandListener {
  private static final int pageItemCount = 8;
  private final AbstractMobActions ma;
  private final String[] help = {
      gm("help-command-action"),
      gm("help-consolecmd-action"),
      gm("help-event-action"),
      gm("help-warp-action"),
      gm("help-action-remove"),
      gm("help-action-cancel"),
      gm("help-command-event"),
      gm("help-consolecmd-event"),
      gm("help-warp-event"),
      gm("help-event-open"),
      gm("help-event-cancel"),
      gm("help-event-remove"),
      gm("help-event-forcestart"),
      gm("help-event-info"),
      gm("help-event-list"),
      gm("help-warp"),
      gm("help-warps-list"),
      gm("help-warps-set"),
      gm("help-warps-remove"),
      gm("help-reload")
  };
  private final String[] subcommands = {
      gm("command-events"), gm("command-help"), gm("command-action"),
      gm("command-reload"), gm("command-warp"), gm("command-warps")
  };
  private final String[] createCommands = {
      gm("command-command"), gm("command-consolecmd"), gm("command-event"),
      gm("command-warp")
  };
  private final String[] eventCommands = {
      gm("command-cancel"), gm("command-create"), gm("command-forcestart"),
      gm("command-info"), gm("command-open"), gm("command-remove")
  };
  private final String[] eventTypes = {
      gm("command-command"), gm("command-consolecmd"), gm("command-warp")
  };
  private final String[] mobCommands = {
      gm("command-cancel"), gm("command-create"), gm("command-remove")
  };
  private final String[] warpCommands = {
      gm("command-set"), gm("command-remove")
  };

  public CommandListenerImpl(AbstractMobActions parent) {
    this.ma = parent;
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, Command command,
                                    String alias, String[] args) {
    MobActionsUser user = ma.getPlayer(sender);
    List<String> completions = new ArrayList<>();
    if (command.getName().equalsIgnoreCase("mac")) {
      if (args.length == 1) {
        StringUtil.copyPartialMatches(args[0], Arrays.asList(subcommands), completions);

      } else if (args.length == 2) {
        if (args[0].equalsIgnoreCase("events")) {
          StringUtil.copyPartialMatches(args[1], Arrays.asList(eventCommands), completions);

        } else if (args[0].equalsIgnoreCase("action")) {
          StringUtil.copyPartialMatches(args[1], Arrays.asList(mobCommands), completions);

        } else if (args[0].equalsIgnoreCase("warps")) {
          StringUtil.copyPartialMatches(args[1], Arrays.asList(warpCommands), completions);

        } else if (args[0].equalsIgnoreCase("warp")) {
          if (user.canUseWarpCommand()) {
            Set<String> warps = ma.getWarpManager().getLoadedWarpNames();
            warps.removeIf(warp -> !user.canUseWarp(warp));
            StringUtil.copyPartialMatches(args[1], new ArrayList<>(warps), completions);
          }
        }

      } else if (args.length == 3) {
        if (args[0].equalsIgnoreCase("action")
            && args[1].equalsIgnoreCase("create") && user.canCreate()) {
          StringUtil.copyPartialMatches(args[2], Arrays.asList(createCommands), completions);

        } else if (args[0].equalsIgnoreCase("events")) {
          if (args[1].equalsIgnoreCase("cancel") && user.canCancelEvents()) {
            Set<MobEvent> events = ma.getMobEventManager().getLoadedEvents();
            ArrayList<String> names = new ArrayList<>();

            for (MobEvent event : events) {
              if (event.getState() != MobEvent.State.CLOSED) {
                names.add(event.getAlias().toLowerCase());
              }
            }

            StringUtil.copyPartialMatches(args[2], names, completions);

          } else if (args[1].equalsIgnoreCase("forcestart") && user.canStartEvents()) {
            Set<MobEvent> events = ma.getMobEventManager().getLoadedEvents();
            ArrayList<String> names = new ArrayList<>();

            for (MobEvent event : events) {
              if (event.getState() == MobEvent.State.OPEN) {
                names.add(event.getAlias().toLowerCase());
              }
            }

            StringUtil.copyPartialMatches(args[2], names, completions);

          } else if (args[1].equalsIgnoreCase("open") && user.canStartEvents()) {
            Set<MobEvent> events = ma.getMobEventManager().getLoadedEvents();
            ArrayList<String> names = new ArrayList<>();

            for (MobEvent event : events) {
              if (event.getState() == MobEvent.State.CLOSED) {
                names.add(event.getAlias().toLowerCase());
              }
            }

            StringUtil.copyPartialMatches(args[2], names, completions);

          } else if (args[1].equalsIgnoreCase("remove") && user.canRemoveEvents()) {
            Set<String> events = ma.getMobEventManager().getLoadedEventNames();
            StringUtil.copyPartialMatches(args[2], new ArrayList<>(events), completions);

          } else if (args[1].equalsIgnoreCase("info") && user.canGetEventInfo()) {
            Set<String> events = ma.getMobEventManager().getLoadedEventNames();
            StringUtil.copyPartialMatches(args[2], new ArrayList<>(events), completions);
          }

        } else if (args[0].equalsIgnoreCase("warps")
            && args[1].equalsIgnoreCase("remove") && user.canRemoveWarp()) {
          Set<String> warps = ma.getWarpManager().getLoadedWarpNames();
          StringUtil.copyPartialMatches(args[2], new ArrayList<>(warps), completions);
        }
      } else if (args.length == 4) {
        if (args[0].equalsIgnoreCase("action")
            && args[1].equalsIgnoreCase("create") && user.canCreate()) {
          if (args[2].equalsIgnoreCase("event")) {
            Set<String> events = ma.getMobEventManager().getLoadedEventNames();
            StringUtil.copyPartialMatches(args[3], new ArrayList<>(events), completions);

          } else if (args[2].equalsIgnoreCase("warp")) {
            Set<String> warps = ma.getWarpManager().getLoadedWarpNames();
            StringUtil.copyPartialMatches(args[3], new ArrayList<>(warps), completions);
          }

        }
      } else if (args.length >= 5) {
        if (args[0].equalsIgnoreCase("events")
            && args[1].equalsIgnoreCase("create") && user.canCreate()) {
          int typeIndexOffset;
          try {
            Integer.parseInt(args[4]);
            typeIndexOffset = 1;
          } catch (NumberFormatException e) {
            typeIndexOffset = 0;
          }

          if (args.length == 5 + typeIndexOffset) {
            StringUtil.copyPartialMatches(args[4 + typeIndexOffset], Arrays.asList(eventTypes),
                completions);
          } else if (args.length == 6 + typeIndexOffset
              && args[4 + typeIndexOffset].equalsIgnoreCase("warp")) {
            Set<String> warps = ma.getWarpManager().getLoadedWarpNames();
            StringUtil.copyPartialMatches(args[5 + typeIndexOffset], new ArrayList<>(warps),
                completions);
          }
        }
      }
    }

    Collections.sort(completions);

    return completions;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label,
                           String[] args) {
    DebugLogger.getLogger().log("Processing command");
    if (command.getName().equalsIgnoreCase("mac")) {
      int page = 0;
      DebugLogger.getLogger().log("Arguments: " + Arrays.toString(args));
      MobActionsUser user = ma.getPlayer(sender);
      PlayerCommand cmd = null;

      if (args.length >= 6 && args[0].equalsIgnoreCase("events")
          && args[1].equalsIgnoreCase("create")) {
        int playerLimit;
        int typeIndexOffset;

        try {
          playerLimit = Integer.parseInt(args[4]);
          typeIndexOffset = 1;
        } catch (NumberFormatException e) {
          playerLimit = 0;
          typeIndexOffset = 0;
        }

        try {
          long waitTime = Long.parseLong(args[3]);

          String type = args[4 + typeIndexOffset];
          if (type.equalsIgnoreCase("command") || type.equalsIgnoreCase("consolecmd")) {
            String[] sublist = Arrays.asList(args).subList(5 + typeIndexOffset, args.length)
                .toArray(new String[]{});
            List<String> strArgs = parseForStrings(sublist);
            if (strArgs.size() == 1) {
              MobData data = new CommandDataImpl(strArgs.get(0),
                  type.equalsIgnoreCase("consolecmd"));
              cmd = new EventCreateCommandImpl(args[2], data, waitTime, playerLimit,
                  ma.getMobEventManager());
            }

          } else if (type.equalsIgnoreCase("warp")) {
            cmd = new EventCreateCommandImpl(
                args[2],
                new WarpDataImpl(args[5 + typeIndexOffset]),
                waitTime,
                playerLimit,
                ma.getMobEventManager()
            );
          }
        } catch (NumberFormatException e) {
          DebugLogger.getLogger().log("Wait time is not a valid long");
        }

      } else if (args.length >= 5 && args[0].equalsIgnoreCase("action")
          && args[1].equalsIgnoreCase("create")
          && (args[2].equalsIgnoreCase("command") || args[2].equalsIgnoreCase("consolecmd"))) {
        String[] sublist = Arrays.asList(args).subList(3, args.length).toArray(new String[]{});
        List<String> strArgs = parseForStrings(sublist);

        DebugLogger.getLogger().log("String arguments: " + strArgs.toString());
        if (strArgs.size() == 2) {
          cmd = new CreateCommandImpl(new CommandDataImpl(strArgs.get(0), strArgs.get(1),
              args[2].equalsIgnoreCase("consolecmd")));

        }
      } else if (args.length == 4 && args[0].equalsIgnoreCase("action")
          && args[1].equalsIgnoreCase("create")
          && args[2].equalsIgnoreCase("event")) {
        cmd = new CreateCommandImpl(new EventDataImpl(args[3]));
      } else if (args.length == 4 && args[0].equalsIgnoreCase("action")
          && args[1].equalsIgnoreCase("create")
          && args[2].equalsIgnoreCase("warp")) {
        cmd = new CreateCommandImpl(new WarpDataImpl(args[3]));
      } else if (args.length == 3 && args[0].equalsIgnoreCase("events")
          && args[1].equalsIgnoreCase("open")) {
        cmd = new EventOpenCommandImpl(args[2], ma.getMobEventManager());
      } else if (args.length == 3 && args[0].equalsIgnoreCase("events")
          && args[1].equalsIgnoreCase("cancel")) {
        cmd = new EventCancelCommandImpl(args[2], ma.getMobEventManager());
      } else if (args.length == 3 && args[0].equalsIgnoreCase("events")
          && args[1].equalsIgnoreCase("remove")) {
        cmd = new EventRemoveCommandImpl(args[2], ma.getMobEventManager());
      } else if (args.length == 3 && args[0].equalsIgnoreCase("events")
          && args[1].equalsIgnoreCase("forcestart")) {
        cmd = new EventForceStartCommandImpl(args[2], ma.getMobEventManager());
      } else if (args.length == 3 && args[0].equalsIgnoreCase("events")
          && args[1].equalsIgnoreCase("info")) {
        cmd = new EventInfoCommandImpl(args[2], ma.getMobEventManager());
      } else if (args.length == 3 && args[0].equalsIgnoreCase("warps")
          && args[1].equalsIgnoreCase("set")) {
        cmd = new SetWarpCommandImpl(args[2], ma.getWarpManager());
      } else if (args.length == 3 && args[0].equalsIgnoreCase("warps")
          && args[1].equalsIgnoreCase("remove")) {
        cmd = new DelWarpCommandImpl(args[2], ma.getWarpManager());
      } else if (args.length == 2 && args[0].equalsIgnoreCase("warp")) {
        cmd = new WarpCommandImpl(args[1], ma.getWarpManager());
      } else if (args.length == 2 && args[0].equalsIgnoreCase("action")
          && args[1].equalsIgnoreCase("remove")) {
        cmd = new RemoveCommandImpl();
      } else if (args.length == 2 && args[0].equalsIgnoreCase("action")
          && args[1].equalsIgnoreCase("cancel")) {
        cmd = new CancelCommandImpl();
      } else if (args.length == 2 && args[0].equalsIgnoreCase("help")) {
        try {
          page = Integer.parseInt(args[1]) - 1;
        } catch (NumberFormatException e) {
          DebugLogger.getLogger().log("Incorrect help command usage");
        }
      } else if (args.length == 1 && args[0].equalsIgnoreCase("events")) {
        cmd = new EventListCommandImpl(ma.getMobEventManager());
      } else if (args.length == 1 && args[0].equalsIgnoreCase("warps")) {
        cmd = new ListWarpsCommandImpl(ma.getWarpManager());
      } else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
        cmd = new ReloadCommandImpl(ma);
      }

      if (cmd != null) {
        DebugLogger.getLogger().log("Running command");
        try {
          cmd.run(user);
        } catch (PlayerException e) {
          DebugLogger.getLogger().log("Error: " + e.getPlayerFormattedString());
          user.sendMessage(e.getPlayerFormattedString());
        }
      } else {
        DebugLogger.getLogger().log("No command run");
        user.sendMessage(getHelp(page));
      }

      return true;
    }

    return false;
  }

  private List<String> parseForStrings(String[] args) {
    String text = String.join(" ", args);
    List<String> strings = new ArrayList<>();
    StringBuilder sb = null;

    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (sb == null && c == '"' && (i == 0 || (text.charAt(i - 1) != '\\'
          || (i >= 2 && text.charAt(i - 2) == '\\')))) {
        sb = new StringBuilder();
      } else if (sb != null) {
        if (c == '"' && (text.charAt(i - 1) != '\\' || (i >= 2 && text.charAt(i - 2) == '\\'))) {
          String str = sb.toString();
          if (str.length() > 0) {
            strings.add(str);
          }
          sb = null;
        } else if (i == text.length() - 1 || text.charAt(i) != '\\' || text.charAt(i + 1) != '"'
            || text.charAt(i - 1) == '\\') {
          sb.append(c);
        }
      }
    }

    return strings;
  }

  private String[] getHelp(int page) {
    ArrayList<String> messages = new ArrayList<>(pageItemCount + 3);
    int startIdx = page * pageItemCount;

    if (startIdx < help.length && startIdx >= 0) {
      messages.add(gm("help-page-number", String.valueOf(page + 1),
          String.valueOf((int) Math.ceil((double) help.length / pageItemCount))));
      messages.add(gm("help-usage"));
      for (int i = 0; i < pageItemCount && i + startIdx < help.length; i++) {
        messages.add(help[i + startIdx]);
      }
      messages.add(gm("help-command-usage"));
    } else {
      messages.add(gm("help-command-error"));
    }

    return messages.toArray(new String[0]);
  }
}

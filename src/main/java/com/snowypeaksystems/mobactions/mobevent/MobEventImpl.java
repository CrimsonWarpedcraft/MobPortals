package com.snowypeaksystems.mobactions.mobevent;

import static com.snowypeaksystems.mobactions.util.Messages.gm;

import com.snowypeaksystems.mobactions.AbstractMobActions;
import com.snowypeaksystems.mobactions.actions.EventMobStartAction;
import com.snowypeaksystems.mobactions.actions.EventMobStartActionImpl;
import com.snowypeaksystems.mobactions.data.CommandData;
import com.snowypeaksystems.mobactions.data.CommandDataImpl;
import com.snowypeaksystems.mobactions.data.MobData;
import com.snowypeaksystems.mobactions.data.WarpData;
import com.snowypeaksystems.mobactions.data.WarpDataImpl;
import com.snowypeaksystems.mobactions.event.MobEventStartEvent;
import com.snowypeaksystems.mobactions.player.MobActionsUser;
import com.snowypeaksystems.mobactions.player.PlayerException;
import com.snowypeaksystems.mobactions.util.DebugLogger;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Implementation of MobEvent.
 *
 * @author Copyright (c) Levi Muniz. All Rights Reserved.
 */
public class MobEventImpl implements MobEvent {
  private final String name;
  private final int maxPlayers;
  private final long timeout;
  private BukkitRunnable timeoutCounter;
  private BukkitRunnable countdown;
  private final Set<MobActionsUser> users;
  private final AbstractMobActions plugin;
  private final MobData data;
  private final File file;
  private State state;

  MobEventImpl(String name, MobData data, long timeout, AbstractMobActions plugin, int maxPlayers,
               File eventFolder) {
    if (timeout < 1) {
      throw new IllegalArgumentException("Argument \"timeout\" cannot be less than 1");
    }

    if (maxPlayers < 0) {
      throw new IllegalArgumentException("Argument \"maxPlayers\" cannot be less than 0");
    }

    this.name = name;
    this.data = data;
    this.timeout = timeout;
    this.plugin = plugin;
    this.maxPlayers = maxPlayers;
    state = State.CLOSED;
    users = new HashSet<>();
    file = new File(eventFolder, String.valueOf(name.toLowerCase().hashCode()));
  }

  MobEventImpl(File file, AbstractMobActions plugin) throws EventConfigException {
    YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
    if (!config.isSet("name") || !config.isSet("timeout")
        || !config.isSet("max-players")) {
      throw new EventConfigException("config key is not set");
    }
    this.file = file;
    this.data = loadData(config);
    this.name = config.getString("name", "");
    this.maxPlayers = config.getInt("max-players", 0);
    this.timeout = config.getLong("timeout");
    this.users = new HashSet<>();
    this.state = State.CLOSED;
    this.plugin = plugin;

    if (timeout < 1) {
      throw new EventConfigException("Property \"timeout\" cannot be less than 1");
    }

    if (maxPlayers < 0) {
      throw new EventConfigException("Property \"maxPlayers\" cannot be less than 0");
    }
  }

  @Override
  public void addPlayer(MobActionsUser player) throws EventStateException {
    if (state != State.OPEN) {
      throw new EventStateException(gm("event-closed-error", name));
    }

    users.add(player);

    if (users.size() == maxPlayers) {
      force();
    }
  }

  @Override
  public void removePlayer(MobActionsUser player) {
    users.remove(player);
  }

  @Override
  public boolean hasPlayerJoined(MobActionsUser player) {
    return users.contains(player);
  }

  @Override
  public Set<MobActionsUser> getPlayerSet() {
    return Set.copyOf(users);
  }

  @Override
  public MobData getData() {
    return data;
  }

  @Override
  public long getTimeout() {
    return timeout;
  }

  @Override
  public int getMaxPlayers() {
    return maxPlayers;
  }

  @Override
  public void open() throws EventStateException {
    if (state != State.CLOSED) {
      throw new EventStateException(gm("event-already-open-error", name));
    }

    state = State.OPEN;
    timeoutCounter = getTimeoutCounter();
    timeoutCounter.runTaskLater(plugin, timeout * 20);
  }

  @Override
  public void forceStart() throws EventStateException {
    if (state != State.OPEN) {
      throw new EventStateException(gm("event-closed-error", name));
    }

    force();
  }

  @Override
  public void cancel() {
    for (MobActionsUser user : users) {
      user.sendMessage(gm("event-cancelled-text", name));
    }

    users.clear();

    if (state == State.OPEN) {
      timeoutCounter.cancel();
    } else if (state == State.COUNTDOWN) {
      countdown.cancel();
    }

    state = State.CLOSED;
  }

  @Override
  public State getState() {
    return state;
  }

  private void force() {
    if (state == State.OPEN) {
      timeoutCounter.cancel();
    }

    state = State.COUNTDOWN;
    countdown = getCountdown();
    countdown.runTaskTimer(plugin, 0, 20);
  }

  @Override
  public String getAlias() {
    return name;
  }

  @Override
  public void save() throws IOException {
    YamlConfiguration config = toYamlConfiguration();

    config.save(file);
  }

  @Override
  public boolean delete() {
    return file.delete();
  }

  private YamlConfiguration toYamlConfiguration() {
    YamlConfiguration config = new YamlConfiguration();
    config.set("name", name);
    config.set("timeout", timeout);
    config.set("max-players", maxPlayers);
    config.set("data", data.getKeyString());

    if (data instanceof WarpData) {
      config.set("warp-name", ((WarpData) data).getAlias());
    } else if (data instanceof CommandData) {
      config.set("command", data.toString());
    }

    return config;
  }

  private MobData loadData(YamlConfiguration config)
      throws EventConfigException {

    if (config.isSet("data")
        && CommandData.COMMAND_KEY.equals(config.getString("data", ""))) {
      return new CommandDataImpl(config.getString("command", ""));
    } else if (config.isSet("data")
        && WarpData.WARP_KEY.equals(config.getString("data", ""))) {
      return new WarpDataImpl(config.getString("warp-name", ""));
    } else {
      throw new EventConfigException("data key not valid");
    }
  }

  private BukkitRunnable getCountdown() {
    MobEventImpl e = this;
    EventMobStartAction action = new EventMobStartActionImpl(data, plugin);
    return new BukkitRunnable() {
      private int seconds = 10;
      @Override
      public void run() {
        if (seconds < 1) {
          super.cancel();
          state = State.CLOSED;

          MobEventStartEvent event = new MobEventStartEvent(e);
          Bukkit.getPluginManager().callEvent(event);
          if (!event.isCancelled()) {
            for (MobActionsUser user : users) {
              try {
                action.run(user);
              } catch (PlayerException e) {
                user.sendMessage(e.getPlayerFormattedString());
              }
            }
          } else {
            DebugLogger.getLogger().log("Event cancelled");
          }

          users.clear();
        } else {
          for (MobActionsUser user : users) {
            user.sendMessage(gm("event-countdown-text", name, String.valueOf(seconds)));
          }
          seconds--;
        }
      }
    };
  }

  private BukkitRunnable getTimeoutCounter() {
    return new BukkitRunnable() {
      @Override
      public void run() {
        state = State.COUNTDOWN;
        countdown = getCountdown();
        countdown.runTaskTimer(plugin, 0, 20);
      }
    };
  }
}

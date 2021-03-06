package com.snowypeaksystems.mobactions.command;

import static com.snowypeaksystems.mobactions.util.Messages.gm;

import com.snowypeaksystems.mobactions.mobevent.EventNotFoundException;
import com.snowypeaksystems.mobactions.mobevent.MobEventManager;
import com.snowypeaksystems.mobactions.player.MobActionsUser;
import com.snowypeaksystems.mobactions.player.PermissionException;
import com.snowypeaksystems.mobactions.player.PlayerException;
import com.snowypeaksystems.mobactions.util.DebugLogger;

/**
 * Implementation of EventCancelCommand.
 *
 * @author Copyright (c) Levi Muniz. All Rights Reserved.
 */
public class EventCancelCommandImpl implements EventCancelCommand {
  private final String name;
  private final MobEventManager manager;

  public EventCancelCommandImpl(String name, MobEventManager manager) {
    this.name = name;
    this.manager = manager;
  }

  @Override
  public void run(MobActionsUser player) throws PlayerException {
    DebugLogger.getLogger().log("Cancelling event");
    if (!player.canCancelEvents()) {
      DebugLogger.getLogger().log("Permission error");
      throw new PermissionException();
    }

    if (!manager.exists(name)) {
      DebugLogger.getLogger().log("Event not found");
      throw new EventNotFoundException(name);
    }

    manager.getEvent(name).cancel();
    player.sendMessage(gm("event-cancel-text", name));
    DebugLogger.getLogger().log("Event cancelled");
  }
}

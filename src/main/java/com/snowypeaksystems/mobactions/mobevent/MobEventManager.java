package com.snowypeaksystems.mobactions.mobevent;

import com.snowypeaksystems.mobactions.AMobActions;
import com.snowypeaksystems.mobactions.actions.MobAction;
import com.snowypeaksystems.mobactions.player.MobActionsUser;
import java.util.HashMap;
import java.util.Map;

public class MobEventManager implements IMobEventManager {
  private final Map<String, IMobEvent> events;
  private final AMobActions plugin;

  public MobEventManager(AMobActions plugin) {
    this.plugin = plugin;
    events = new HashMap<>();
  }

  @Override
  public IMobEvent createEvent(String name, int maxPlayers, long timeout, MobAction data) {
    IMobEvent event = new MobEvent(name, maxPlayers, timeout, data, plugin);

    events.put(name.toLowerCase(), event);

    return event;
  }

  @Override
  public void removeEvent(String name) {
    IMobEvent event = events.remove(name.toLowerCase());

    if (event != null && !event.getRunnableTask().isCancelled()) {
      event.getRunnableTask().cancel();
    }
  }

  @Override
  public IMobEvent getEvent(String name) {
    return events.get(name.toLowerCase());
  }

  @Override
  public boolean exists(String name) {
    return events.containsKey(name.toLowerCase());
  }

  @Override
  public void clear() {
    events.clear();
  }

  @Override
  public void removeFromAll(MobActionsUser player) {
    for (IMobEvent event : events.values()) {
      event.removePlayer(player);
    }
  }
}
package com.snowypeaksystems.mobactions.data;

import static com.snowypeaksystems.mobactions.util.Messages.gm;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Stores a String command.
 * @author Copyright (c) Levi Muniz. All Rights Reserved.
 */
public class CommandData implements ConsoleCommandData {
  private final String command;
  private final String description;
  private final String tokenStr = String.valueOf(new char[]{TOKEN_PREFIX, TOKEN_SUFFIX});

  /** Constructs CommandData from an entity. */
  public CommandData(LivingEntity entity, JavaPlugin plugin) throws IncompleteDataException {
    PersistentDataContainer container = entity.getPersistentDataContainer();
    NamespacedKey commandKey = new NamespacedKey(plugin, COMMAND_KEY);
    NamespacedKey descriptionKey = new NamespacedKey(plugin, COMMAND_DESCRIPTION_KEY);

    if (!container.has(commandKey, PersistentDataType.STRING)
        || !container.has(descriptionKey, PersistentDataType.STRING)) {
      throw new IncompleteDataException();
    }

    this.command = container.get(commandKey, PersistentDataType.STRING);
    this.description = container.get(descriptionKey, PersistentDataType.STRING);
  }

  /** Constructs a command given a command to execute. */
  public CommandData(String command) {
    this(command, null);
  }

  /** Constructs a command given a command to execute and description. */
  public CommandData(String command, String description) {
    this.command = command;

    if (description != null && description.length() > 0) {
      this.description = description;
    } else {
      this.description = "\"" + command + "\"";
    }
  }

  @Override
  public String getCommand(String name) {
    int start = 0;
    int[] positions = new int[2];
    StringBuilder newString = new StringBuilder();

    for (int i = 0, j = 0; i < command.length(); i++) {
      if (command.charAt(i) == tokenStr.charAt(j) && (i == 0 || command.charAt(i - 1) != '\\'
          || (i >= 2 && command.charAt(i - 2) == '\\'))) {
        positions[j] = i;
        j++;
      }

      if (j == positions.length) {
        int end = positions[0];
        if (positions[0] >= 2 && command.startsWith("\\\\", positions[0] - 2)) {
          end = positions[0] - 1;
        }
        String segment = command.substring(start, end).replaceAll("(?<!\\\\)\\\\\\{", "{")
            .replaceAll("(?<!\\\\)\\\\}", "}");
        newString.append(segment).append(name);
        start = i + 1;
        j = 0;
      }
    }

    newString.append(command.substring(start).replaceAll("(?<!\\\\)\\\\\\{", "{")
        .replaceAll("(?<!\\\\)\\\\}", "}"));

    return newString.toString();
  }

  @Override
  public void store(LivingEntity entity, JavaPlugin plugin) {
    entity.getPersistentDataContainer()
        .set(new NamespacedKey(plugin, COMMAND_KEY), PersistentDataType.STRING, command);
    entity.getPersistentDataContainer()
        .set(new NamespacedKey(plugin, COMMAND_DESCRIPTION_KEY),
            PersistentDataType.STRING, description);
    // TODO Mason, store, purge, and load if console command
  }

  @Override
  public void purge(LivingEntity entity, JavaPlugin plugin) {
    entity.getPersistentDataContainer().remove(new NamespacedKey(plugin, COMMAND_KEY));
    entity.getPersistentDataContainer().remove(new NamespacedKey(plugin, COMMAND_DESCRIPTION_KEY));
  }

  @Override
  public String getKeyString() {
    return COMMAND_KEY;
  }

  @Override
  public String getNametagString() {
    return gm("nametag-command-text", description);
  }

  @Override
  public String toString() {
    return command;
  }

  @Override
  public boolean isConsoleCommand() {
    // TODO Mason, implement
    return false;
  }
}

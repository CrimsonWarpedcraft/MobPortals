package com.snowypeaksystems.mobportals.messages;

import com.snowypeaksystems.mobportals.exceptions.MessageNotFoundException;
import java.util.HashMap;

/**
 * Collection of messages to be used throughout the project.
 * @author Copyright (c) Levi Muniz. All Rights Reserved.
 */
public class Messages {
  private static HashMap<String, IMessage> messages;
  public static final String TOKEN = "{}";

  /**
   * Get the message for the given string, replacing instances of IMessages.TOKEN with args.
   * @param key the identifier of the message
   * @param args list of strings to replace tokens with in messages
   * @return Returns the message for the key
   * @throws MessageNotFoundException If a message is not found for the provided key
   */
  public static String gm(String key, String... args) {
    if (messages == null) {
      initialize();
    }

    if (!messages.containsKey(key)) {
      throw new MessageNotFoundException(key);
    }

    return messages.get(key).getMessage(args);
  }

  /** Loads message data. */
  public static void initialize() {
    // TODO: Load other language translations if available in data folder and store in 2D map
    messages = new HashMap<>();

    // Console messages
    messages.put("console-command-error",
        new Message("&cYou cannot execute commands from the console!"));

    // List messages
    messages.put("list-message", new Message("&aAvailable warps:"));
    messages.put("list-empty-message", new Message("&eNo warps available!"));

    // Mob nametag message
    messages.put("mob-nametag-text", new Message("&6Click to warp to {&c}!", TOKEN));

    // Permission messages
    messages.put("permission-error",
        new Message("You need the {} permission node to do that!", TOKEN));

    // Portal cancel messages
    messages.put("portal-cancel", new Message("&eUse /mp cancel to cancel"));
    messages.put("portal-cancel-error", new Message("&eNothing to cancel!"));
    messages.put("portal-cancel-success", new Message("&eCancelled!"));

    // Portal create messages
    messages.put("portal-create",
        new Message("&bRight click on a mob to create a portal to {&c}", TOKEN));
    messages.put("portal-create-error", new Message("&cPortals cannot be set to players!"));
    messages.put("portal-create-success",
        new Message("&aPortal to {&c} created successfully!", TOKEN));

    // Portal remove messages
    messages.put("portal-remove", new Message("&bRight click on a mob to remove the portal"));
    messages.put("portal-remove-error", new Message("&cNo portal found!"));
    messages.put("portal-remove-success", new Message("&aPortal successfully removed!"));

    // Reload messages
    messages.put("reload-success", new Message("&aMobPortals reload complete!"));
    messages.put("reload-error",
        new Message("&cUnable to reload MobPortals! Some things may not be working properly..."));

    // Warp messages
    messages.put("warp-create-error", new Message("&cWarp \"{}\" already exists!", TOKEN));
    messages.put("warp-create-success",
        new Message("&aWarp {&c} created successfully!", TOKEN));
    messages.put("warp-delete-success",
        new Message("&aWarp {&c} deleted successfully!", TOKEN));
    messages.put("warp-missing", new Message("&cWarp \"{}\" not found!", TOKEN));
    messages.put("warp-save-error", new Message("&cCouldn't save warp \"{}\"!", TOKEN));
    messages.put("warp-success", new Message("&6Welcome to {&c}!", TOKEN));
  }
}

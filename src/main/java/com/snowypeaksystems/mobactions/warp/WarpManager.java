package com.snowypeaksystems.mobactions.warp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.Location;

/**
 * A map implementation used for warps that persists the keys upon write and remove.
 * This is particularly useful for making sure we keep track of warp locations even after restart.
 * @author Copyright (c) Levi Muniz. All Rights Reserved.
 */
public class WarpManager implements IWarpManager {
  private final File storageDir;
  private HashMap<String, IWarp> warps;

  /**
   * Construct a new WarpManager map from the specified dataDir and server.
   * @param dataDir folder for the map to write to
   * @throws FileNotFoundException if dataDir does not exist
   */
  public WarpManager(File dataDir) throws FileNotFoundException {
    if (dataDir == null || !dataDir.exists()) {
      throw new FileNotFoundException("Warp directory not found");
    }

    this.storageDir = dataDir;
    this.warps = new HashMap<>();

    reload();
  }

  @Override
  public IWarp makeWarp(String name, Location destination) {
    IWarp warp = new Warp(name.toLowerCase(), destination, storageDir);
    warps.put(warp.getAlias(), warp);
    return warp;
  }

  @Override
  public IWarp getWarp(String name) {
    return warps.get(name.toLowerCase());
  }

  @Override
  public IWarp unregister(String name) {
    return warps.remove(name.toLowerCase());
  }

  @Override
  public boolean exists(String name) {
    return warps.containsKey(name.toLowerCase());
  }

  @Override
  public Set<String> getLoadedWarpNames() {
    return warps.keySet();
  }

  @Override
  public void reload() {
    warps = new HashMap<>();
    File[] files = storageDir.listFiles();

    // TODO: Maybe async this?
    if (files != null) {
      for (File f : files) {
        if (f.getName().startsWith(".")) {
          continue;
        }

        try {
          IWarp warp = new Warp(f);
          warps.put(warp.getAlias().toLowerCase(), warp);
        } catch (WarpConfigException e) {
          Bukkit.getLogger().log(Level.FINE, e.getMessage(), e);
        }
      }
    }
  }
}
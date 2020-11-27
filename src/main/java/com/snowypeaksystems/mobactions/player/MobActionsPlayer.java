package com.snowypeaksystems.mobactions.player;

import com.snowypeaksystems.mobactions.mob.data.MobData;
import com.snowypeaksystems.mobactions.mob.data.command.ICommandData;
import com.snowypeaksystems.mobactions.mob.data.warp.IWarp;
import org.bukkit.entity.Player;

/**
 * Implementation of IMPPlayer.
 * @author Copyright (c) Levi Muniz. All Rights Reserved.
 */
public class MobActionsPlayer implements IMobActionsPlayer {
  private final Player player;

  public MobActionsPlayer(Player player) {
    this.player = player;
  }

  @Override
  public void setCreating(MobData data) {

  }

  @Override
  public void setDestroying(boolean value) {

  }

  @Override
  public IStatus getStatus() {
    return null;
  }

  @Override
  public Player getPlayer() {
    return player;
  }

  @Override
  public boolean canUseWarp(IWarp warp) {
    return player.hasPermission("mobactions.warp.*")
        || player.hasPermission("mobactions.warp." + warp.getAlias());
  }

  @Override
  public boolean canRunCommand(ICommandData command) {
    return player.hasPermission("mobactions.command.*")
        || player.hasPermission("mobactions.command." + command.getAlias());
  }

  @Override
  public boolean canCreatePortal() {
    return player.hasPermission("mobactions.admin.createportal");
  }

  @Override
  public boolean canCreateCommand() {
    return player.hasPermission("mobactions.admin.createcommand");
  }

  @Override
  public boolean canRemove() {
    return player.hasPermission("mobactions.admin.remove");
  }

  @Override
  public boolean canUseWarpCommand() {
    return player.hasPermission("mobactions.warp");
  }

  @Override
  public boolean canSetWarp() {
    return player.hasPermission("mobactions.admin.setwarp");
  }

  @Override
  public boolean canRemoveWarp() {
    return player.hasPermission("mobactions.admin.delwarp");
  }

  @Override
  public boolean canReload() {
    return player.hasPermission("mobactions.admin.reload");
  }
}

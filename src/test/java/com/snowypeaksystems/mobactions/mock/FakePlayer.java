package com.snowypeaksystems.mobactions.mock;

import com.destroystokyo.paper.ClientOption;
import com.destroystokyo.paper.Title;
import com.destroystokyo.paper.block.TargetBlockInfo;
import com.destroystokyo.paper.entity.TargetEntityInfo;
import com.destroystokyo.paper.profile.PlayerProfile;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Chunk;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.FluidCollisionMode;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Note;
import org.bukkit.Particle;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.World;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityCategory;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Pose;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Villager;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MainHand;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Dummy implementation for Player.
 *
 * @author Copyright (c) Levi Muniz. All Rights Reserved.
 */
@SuppressFBWarnings
public class FakePlayer implements Player {
  HashMap<String, Boolean> perms = new HashMap<>();

  public void setPermission(String name, boolean value) {
    perms.put(name, value);
  }

  @Override
  public @NotNull Component displayName() {
    return null;
  }

  @Override
  public void displayName(@Nullable Component displayName) {

  }

  @Override
  public String getDisplayName() {
    return null;
  }

  @Override
  public void setDisplayName(String name) {

  }

  @Override
  public void playerListName(@Nullable Component name) {

  }

  @Override
  public @Nullable Component playerListName() {
    return null;
  }

  @Override
  public @Nullable Component playerListHeader() {
    return null;
  }

  @Override
  public @Nullable Component playerListFooter() {
    return null;
  }

  @Override
  public String getPlayerListName() {
    return null;
  }

  @Override
  public void setPlayerListName(String name) {

  }

  @Override
  public String getPlayerListHeader() {
    return null;
  }

  @Override
  public String getPlayerListFooter() {
    return null;
  }

  @Override
  public void setPlayerListHeader(String header) {

  }

  @Override
  public void setPlayerListFooter(String footer) {

  }

  @Override
  public void setCompassTarget(Location loc) {

  }

  @Override
  public Location getCompassTarget() {
    return null;
  }

  @Override
  public InetSocketAddress getAddress() {
    return null;
  }

  @Override
  public int getProtocolVersion() {
    return 0;
  }

  @Override
  public InetSocketAddress getVirtualHost() {
    return null;
  }

  @Override
  public boolean isConversing() {
    return false;
  }

  @Override
  public void acceptConversationInput(String input) {

  }

  @Override
  public boolean beginConversation(Conversation conversation) {
    return false;
  }

  @Override
  public void abandonConversation(Conversation conversation) {

  }

  @Override
  public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {

  }

  @Override
  public void sendRawMessage(String message) {

  }

  @Override
  public void sendRawMessage(UUID uuid, String s) {

  }

  @Override
  public void kickPlayer(String message) {

  }

  @Override
  public void kick(@Nullable Component message) {

  }

  @Override
  public void kick(@Nullable Component message, PlayerKickEvent.@NotNull Cause cause) {

  }

  @Override
  public void chat(String msg) {

  }

  @Override
  public boolean performCommand(String command) {
    return false;
  }

  @Override
  public Location getLocation() {
    return null;
  }

  @Override
  public Location getLocation(Location loc) {
    return null;
  }

  @Override
  public void setVelocity(Vector velocity) {

  }

  @Override
  public Vector getVelocity() {
    return null;
  }

  @Override
  public double getHeight() {
    return 0;
  }

  @Override
  public double getWidth() {
    return 0;
  }

  @Override
  public BoundingBox getBoundingBox() {
    return null;
  }

  @Override
  public boolean isOnGround() {
    return false;
  }

  @Override
  public World getWorld() {
    return null;
  }

  @Override
  public void setRotation(float yaw, float pitch) {

  }

  @Override
  public boolean teleport(Location location) {
    return false;
  }

  @Override
  public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
    return false;
  }

  @Override
  public boolean teleport(Entity destination) {
    return false;
  }

  @Override
  public boolean teleport(Entity destination, PlayerTeleportEvent.TeleportCause cause) {
    return false;
  }

  @Override
  public List<Entity> getNearbyEntities(double x, double y, double z) {
    return null;
  }

  @Override
  public int getEntityId() {
    return 0;
  }

  @Override
  public int getFireTicks() {
    return 0;
  }

  @Override
  public int getMaxFireTicks() {
    return 0;
  }

  @Override
  public void setFireTicks(int ticks) {

  }

  @Override
  public void remove() {

  }

  @Override
  public boolean isDead() {
    return false;
  }

  @Override
  public boolean isValid() {
    return false;
  }

  @Override
  public void sendMessage(String message) {

  }

  @Override
  public void sendMessage(String[] messages) {

  }

  @Override
  public void sendMessage(UUID uuid, String s) {

  }

  @Override
  public void sendMessage(UUID uuid, String[] strings) {

  }

  @Override
  public Server getServer() {
    return null;
  }

  @Override
  public boolean isPersistent() {
    return false;
  }

  @Override
  public void setPersistent(boolean persistent) {

  }

  @Override
  public Entity getPassenger() {
    return null;
  }

  @Override
  public boolean setPassenger(Entity passenger) {
    return false;
  }

  @Override
  public List<Entity> getPassengers() {
    return null;
  }

  @Override
  public boolean addPassenger(Entity passenger) {
    return false;
  }

  @Override
  public boolean removePassenger(Entity passenger) {
    return false;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean eject() {
    return false;
  }

  @Override
  public float getFallDistance() {
    return 0;
  }

  @Override
  public void setFallDistance(float distance) {

  }

  @Override
  public void setLastDamageCause(EntityDamageEvent event) {

  }

  @Override
  public EntityDamageEvent getLastDamageCause() {
    return null;
  }

  @Override
  public UUID getUniqueId() {
    return null;
  }

  @Override
  public int getTicksLived() {
    return 0;
  }

  @Override
  public void setTicksLived(int value) {

  }

  @Override
  public EntityType getType() {
    return null;
  }

  @Override
  public boolean isInsideVehicle() {
    return false;
  }

  @Override
  public boolean leaveVehicle() {
    return false;
  }

  @Override
  public Entity getVehicle() {
    return null;
  }

  @Override
  public void setCustomNameVisible(boolean flag) {

  }

  @Override
  public boolean isCustomNameVisible() {
    return false;
  }

  @Override
  public void setGlowing(boolean flag) {

  }

  @Override
  public boolean isGlowing() {
    return false;
  }

  @Override
  public void setInvulnerable(boolean flag) {

  }

  @Override
  public boolean isInvulnerable() {
    return false;
  }

  @Override
  public boolean isSilent() {
    return false;
  }

  @Override
  public void setSilent(boolean flag) {

  }

  @Override
  public boolean hasGravity() {
    return false;
  }

  @Override
  public void setGravity(boolean gravity) {

  }

  @Override
  public int getPortalCooldown() {
    return 0;
  }

  @Override
  public void setPortalCooldown(int cooldown) {

  }

  @Override
  public Set<String> getScoreboardTags() {
    return null;
  }

  @Override
  public boolean addScoreboardTag(String tag) {
    return false;
  }

  @Override
  public boolean removeScoreboardTag(String tag) {
    return false;
  }

  @Override
  public PistonMoveReaction getPistonMoveReaction() {
    return null;
  }

  @Override
  public BlockFace getFacing() {
    return null;
  }

  @Override
  public Pose getPose() {
    return null;
  }

  @Override
  public boolean isSneaking() {
    return false;
  }

  @Override
  public void setSneaking(boolean sneak) {

  }

  @Override
  public boolean isSprinting() {
    return false;
  }

  @Override
  public void setSprinting(boolean sprinting) {

  }

  @Override
  public void saveData() {

  }

  @Override
  public void loadData() {

  }

  @Override
  public void setSleepingIgnored(boolean isSleeping) {

  }

  @Override
  public boolean isSleepingIgnored() {
    return false;
  }

  @Override
  public boolean isOnline() {
    return false;
  }

  @Override
  public boolean isBanned() {
    return false;
  }

  @Override
  public boolean isWhitelisted() {
    return false;
  }

  @Override
  public void setWhitelisted(boolean value) {

  }

  @Override
  public Player getPlayer() {
    return null;
  }

  @Override
  public long getFirstPlayed() {
    return 0;
  }

  @Override
  public long getLastPlayed() {
    return 0;
  }

  @Override
  public boolean hasPlayedBefore() {
    return false;
  }

  @Override
  public Location getBedSpawnLocation() {
    return null;
  }

  @Override
  public long getLastLogin() {
    return 0;
  }

  @Override
  public long getLastSeen() {
    return 0;
  }

  @Override
  public void incrementStatistic(Statistic statistic) throws IllegalArgumentException {

  }

  @Override
  public void incrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {

  }

  @Override
  public void incrementStatistic(Statistic statistic, Material material)
      throws IllegalArgumentException {

  }

  @Override
  public void incrementStatistic(Statistic statistic, Material material, int amount)
      throws IllegalArgumentException {

  }

  @Override
  public void incrementStatistic(Statistic statistic, EntityType entityType)
      throws IllegalArgumentException {

  }

  @Override
  public void incrementStatistic(Statistic statistic, EntityType entityType, int amount)
      throws IllegalArgumentException {

  }

  @Override
  public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {

  }

  @Override
  public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {

  }

  @Override
  public void decrementStatistic(Statistic statistic, Material material)
      throws IllegalArgumentException {

  }

  @Override
  public void decrementStatistic(Statistic statistic, Material material, int amount)
      throws IllegalArgumentException {

  }

  @Override
  public void decrementStatistic(Statistic statistic, EntityType entityType)
      throws IllegalArgumentException {

  }

  @Override
  public void decrementStatistic(Statistic statistic, EntityType entityType, int amount) {

  }

  @Override
  public int getStatistic(Statistic statistic) throws IllegalArgumentException {
    return 0;
  }

  @Override
  public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
    return 0;
  }

  @Override
  public int getStatistic(Statistic statistic, EntityType entityType)
      throws IllegalArgumentException {
    return 0;
  }

  @Override
  public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException {

  }

  @Override
  public void setStatistic(Statistic statistic, Material material, int newValue)
      throws IllegalArgumentException {

  }

  @Override
  public void setStatistic(Statistic statistic, EntityType entityType, int newValue) {

  }

  @Override
  public void setBedSpawnLocation(Location location) {

  }

  @Override
  public void setBedSpawnLocation(Location location, boolean force) {

  }

  @Override
  public void playNote(Location loc, byte instrument, byte note) {

  }

  @Override
  public void playNote(Location loc, Instrument instrument, Note note) {

  }

  @Override
  public void playSound(Location location, Sound sound, float volume, float pitch) {

  }

  @Override
  public void playSound(Location location, String sound, float volume, float pitch) {

  }

  @Override
  public void playSound(Location location, Sound sound, SoundCategory category, float volume,
                        float pitch) {

  }

  @Override
  public void playSound(Location location, String sound, SoundCategory category, float volume,
                        float pitch) {

  }

  @Override
  public void stopSound(Sound sound) {

  }

  @Override
  public void stopSound(String sound) {

  }

  @Override
  public void stopSound(Sound sound, SoundCategory category) {

  }

  @Override
  public void stopSound(String sound, SoundCategory category) {

  }

  @Override
  public void playEffect(EntityEffect type) {

  }

  @Override
  public void playEffect(Location loc, Effect effect, int data) {

  }

  @Override
  public <T> void playEffect(Location loc, Effect effect, T data) {

  }

  @Override
  public void sendBlockChange(Location loc, Material material, byte data) {

  }

  @Override
  public void sendBlockChange(Location loc, BlockData block) {

  }

  @Override
  public void sendBlockDamage(@NotNull Location loc, float progress) {

  }

  @Override
  public boolean sendChunkChange(Location loc, int sx, int sy, int sz, byte[] data) {
    return false;
  }

  @Override
  public void sendSignChange(@NotNull Location loc, @Nullable List<Component> lines)
      throws IllegalArgumentException {

  }

  @Override
  public void sendSignChange(@NotNull Location loc, @Nullable List<Component> lines,
                             @NotNull DyeColor dyeColor) throws IllegalArgumentException {

  }

  @Override
  public void sendSignChange(Location loc, String[] lines) throws IllegalArgumentException {

  }

  @Override
  public void sendSignChange(Location loc, String[] lines, DyeColor dyeColor)
      throws IllegalArgumentException {

  }

  @Override
  public void sendMap(MapView map) {

  }

  @Override
  public void sendActionBar(String message) {

  }

  @Override
  public void sendActionBar(char alternateChar, String message) {

  }

  @Override
  public void sendActionBar(BaseComponent... message) {

  }

  @Override
  public void setPlayerListHeaderFooter(String header, String footer) {

  }

  @Override
  public void setPlayerListHeaderFooter(BaseComponent[] header, BaseComponent[] footer) {

  }

  @Override
  public void setPlayerListHeaderFooter(BaseComponent header, BaseComponent footer) {

  }

  @Override
  public void setTitleTimes(int fadeInTicks, int stayTicks, int fadeOutTicks) {

  }

  @Override
  public void setSubtitle(BaseComponent[] subtitle) {

  }

  @Override
  public void setSubtitle(BaseComponent subtitle) {

  }

  @Override
  public void showTitle(BaseComponent[] title) {

  }

  @Override
  public void showTitle(BaseComponent title) {

  }

  @Override
  public void showTitle(BaseComponent[] title, BaseComponent[] subtitle, int fadeInTicks,
                        int stayTicks, int fadeOutTicks) {

  }

  @Override
  public void showTitle(BaseComponent title, BaseComponent subtitle, int fadeInTicks,
                        int stayTicks, int fadeOutTicks) {

  }

  @Override
  public void updateTitle(Title title) {

  }

  @Override
  public void hideTitle() {

  }

  @Override
  public void updateInventory() {

  }

  @Override
  public void setPlayerTime(long time, boolean relative) {

  }

  @Override
  public long getPlayerTime() {
    return 0;
  }

  @Override
  public long getPlayerTimeOffset() {
    return 0;
  }

  @Override
  public boolean isPlayerTimeRelative() {
    return false;
  }

  @Override
  public void resetPlayerTime() {

  }

  @Override
  public void setPlayerWeather(WeatherType type) {

  }

  @Override
  public WeatherType getPlayerWeather() {
    return null;
  }

  @Override
  public void resetPlayerWeather() {

  }

  @Override
  public void giveExp(int amount, boolean applyMending) {

  }

  @Override
  public int applyMending(int amount) {
    return 0;
  }

  @Override
  public void giveExpLevels(int amount) {

  }

  @Override
  public float getExp() {
    return 0;
  }

  @Override
  public void setExp(float exp) {

  }

  @Override
  public int getLevel() {
    return 0;
  }

  @Override
  public void setLevel(int level) {

  }

  @Override
  public int getTotalExperience() {
    return 0;
  }

  @Override
  public void setTotalExperience(int exp) {

  }

  @Override
  public void sendExperienceChange(float progress) {

  }

  @Override
  public void sendExperienceChange(float progress, int level) {

  }

  @Override
  public float getExhaustion() {
    return 0;
  }

  @Override
  public void setExhaustion(float value) {

  }

  @Override
  public float getSaturation() {
    return 0;
  }

  @Override
  public void setSaturation(float value) {

  }

  @Override
  public int getFoodLevel() {
    return 0;
  }

  @Override
  public void setFoodLevel(int value) {

  }

  @Override
  public int getSaturatedRegenRate() {
    return 0;
  }

  @Override
  public void setSaturatedRegenRate(int ticks) {

  }

  @Override
  public int getUnsaturatedRegenRate() {
    return 0;
  }

  @Override
  public void setUnsaturatedRegenRate(int ticks) {

  }

  @Override
  public int getStarvationRate() {
    return 0;
  }

  @Override
  public void setStarvationRate(int ticks) {

  }

  @Override
  public boolean getAllowFlight() {
    return false;
  }

  @Override
  public void setAllowFlight(boolean flight) {

  }

  @Override
  public void hidePlayer(Player player) {

  }

  @Override
  public void hidePlayer(Plugin plugin, Player player) {

  }

  @Override
  public void showPlayer(Player player) {

  }

  @Override
  public void showPlayer(Plugin plugin, Player player) {

  }

  @Override
  public boolean canSee(Player player) {
    return false;
  }

  @Override
  public boolean isFlying() {
    return false;
  }

  @Override
  public void setFlying(boolean value) {

  }

  @Override
  public void setFlySpeed(float value) throws IllegalArgumentException {

  }

  @Override
  public void setWalkSpeed(float value) throws IllegalArgumentException {

  }

  @Override
  public float getFlySpeed() {
    return 0;
  }

  @Override
  public float getWalkSpeed() {
    return 0;
  }

  @Override
  public void setTexturePack(String url) {

  }

  @Override
  public void setResourcePack(String url) {

  }

  @Override
  public void setResourcePack(String url, byte[] hash) {

  }

  @Override
  public void setResourcePack(String url, String hash) {

  }

  @Override
  public Scoreboard getScoreboard() {
    return null;
  }

  @Override
  public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException,
      IllegalStateException {

  }

  @Override
  public boolean isHealthScaled() {
    return false;
  }

  @Override
  public void setHealthScaled(boolean scale) {

  }

  @Override
  public void setHealthScale(double scale) throws IllegalArgumentException {

  }

  @Override
  public double getHealthScale() {
    return 0;
  }

  @Override
  public Entity getSpectatorTarget() {
    return null;
  }

  @Override
  public void setSpectatorTarget(Entity entity) {

  }

  @Override
  public void sendTitle(Title title) {

  }

  @Override
  public void sendTitle(String title, String subtitle) {

  }

  @Override
  public void sendTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {

  }

  @Override
  public void resetTitle() {

  }

  @Override
  public void spawnParticle(Particle particle, Location location, int count) {

  }

  @Override
  public void spawnParticle(Particle particle, double x, double y, double z, int count) {

  }

  @Override
  public <T> void spawnParticle(Particle particle, Location location, int count, T data) {

  }

  @Override
  public <T> void spawnParticle(Particle particle, double x, double y, double z, int count,
                                T data) {

  }

  @Override
  public void spawnParticle(Particle particle, Location location, int count, double offsetX,
                            double offsetY, double offsetZ) {

  }

  @Override
  public void spawnParticle(Particle particle, double x, double y, double z, int count,
                            double offsetX, double offsetY, double offsetZ) {

  }

  @Override
  public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX,
                                double offsetY, double offsetZ, T data) {

  }

  @Override
  public <T> void spawnParticle(Particle particle, double x, double y, double z, int count,
                                double offsetX, double offsetY, double offsetZ, T data) {

  }

  @Override
  public void spawnParticle(Particle particle, Location location, int count, double offsetX,
                            double offsetY, double offsetZ, double extra) {

  }

  @Override
  public void spawnParticle(Particle particle, double x, double y, double z, int count,
                            double offsetX, double offsetY, double offsetZ, double extra) {

  }

  @Override
  public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX,
                                double offsetY, double offsetZ, double extra, T data) {

  }

  @Override
  public <T> void spawnParticle(Particle particle, double x, double y, double z, int count,
                                double offsetX, double offsetY, double offsetZ, double extra,
                                T data) {

  }

  @Override
  public AdvancementProgress getAdvancementProgress(Advancement advancement) {
    return null;
  }

  @Override
  public int getClientViewDistance() {
    return 0;
  }

  @Override
  public @NotNull Locale locale() {
    return null;
  }

  @Override
  public int getPing() {
    return 0;
  }

  @Override
  public String getLocale() {
    return null;
  }

  @Override
  public boolean getAffectsSpawning() {
    return false;
  }

  @Override
  public void setAffectsSpawning(boolean affects) {

  }

  @Override
  public int getViewDistance() {
    return 0;
  }

  @Override
  public void setViewDistance(int viewDistance) {

  }

  @Override
  public void updateCommands() {

  }

  @Override
  public void openBook(ItemStack book) {

  }

  @Override
  public PlayerResourcePackStatusEvent.Status getResourcePackStatus() {
    return null;
  }

  @Override
  public String getResourcePackHash() {
    return null;
  }

  @Override
  public boolean hasResourcePack() {
    return false;
  }

  @Override
  public PlayerProfile getPlayerProfile() {
    return null;
  }

  @Override
  public void setPlayerProfile(PlayerProfile profile) {

  }

  @Override
  public float getCooldownPeriod() {
    return 0;
  }

  @Override
  public float getCooledAttackStrength(float adjustTicks) {
    return 0;
  }

  @Override
  public void resetCooldown() {

  }

  @Override
  public <T> T getClientOption(ClientOption<T> option) {
    return null;
  }

  @Override
  public Firework boostElytra(ItemStack firework) {
    return null;
  }

  @Override
  public void sendOpLevel(byte level) {

  }

  @Override
  public @NotNull Set<Player> getTrackedPlayers() {
    return null;
  }

  @Override
  public String getClientBrandName() {
    return null;
  }

  @Override
  public Spigot spigot() {
    return null;
  }

  @Override
  public Location getOrigin() {
    return null;
  }

  @Override
  public boolean fromMobSpawner() {
    return false;
  }

  @Override
  public Chunk getChunk() {
    return null;
  }

  @Override
  public CreatureSpawnEvent.SpawnReason getEntitySpawnReason() {
    return null;
  }

  @Override
  public boolean isInWater() {
    return false;
  }

  @Override
  public boolean isInRain() {
    return false;
  }

  @Override
  public boolean isInBubbleColumn() {
    return false;
  }

  @Override
  public boolean isInWaterOrRain() {
    return false;
  }

  @Override
  public boolean isInWaterOrBubbleColumn() {
    return false;
  }

  @Override
  public boolean isInWaterOrRainOrBubbleColumn() {
    return false;
  }

  @Override
  public boolean isInLava() {
    return false;
  }

  @Override
  public boolean isTicking() {
    return false;
  }

  @Override
  public Map<String, Object> serialize() {
    return null;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public PlayerInventory getInventory() {
    return null;
  }

  @Override
  public Inventory getEnderChest() {
    return null;
  }

  @Override
  public MainHand getMainHand() {
    return null;
  }

  @Override
  public boolean setWindowProperty(InventoryView.Property prop, int value) {
    return false;
  }

  @Override
  public InventoryView getOpenInventory() {
    return null;
  }

  @Override
  public InventoryView openInventory(Inventory inventory) {
    return null;
  }

  @Override
  public void openInventory(InventoryView inventory) {

  }

  @Override
  public InventoryView openWorkbench(Location location, boolean force) {
    return null;
  }

  @Override
  public InventoryView openEnchanting(Location location, boolean force) {
    return null;
  }

  @Override
  public InventoryView openMerchant(Villager trader, boolean force) {
    return null;
  }

  @Override
  public InventoryView openMerchant(Merchant merchant, boolean force) {
    return null;
  }

  @Override
  public InventoryView openAnvil(Location location, boolean force) {
    return null;
  }

  @Override
  public InventoryView openCartographyTable(Location location, boolean force) {
    return null;
  }

  @Override
  public InventoryView openGrindstone(Location location, boolean force) {
    return null;
  }

  @Override
  public InventoryView openLoom(Location location, boolean force) {
    return null;
  }

  @Override
  public InventoryView openSmithingTable(Location location, boolean force) {
    return null;
  }

  @Override
  public InventoryView openStonecutter(Location location, boolean force) {
    return null;
  }

  @Override
  public void closeInventory() {

  }

  @Override
  public void closeInventory(InventoryCloseEvent.Reason reason) {

  }

  @Override
  public ItemStack getItemInHand() {
    return null;
  }

  @Override
  public void setItemInHand(ItemStack item) {

  }

  @Override
  public ItemStack getItemOnCursor() {
    return null;
  }

  @Override
  public void setItemOnCursor(ItemStack item) {

  }

  @Override
  public boolean hasCooldown(Material material) {
    return false;
  }

  @Override
  public int getCooldown(Material material) {
    return 0;
  }

  @Override
  public void setCooldown(Material material, int ticks) {

  }

  @Override
  public boolean isDeeplySleeping() {
    return false;
  }

  @Override
  public int getSleepTicks() {
    return 0;
  }

  @Override
  public Location getPotentialBedLocation() {
    return null;
  }

  @Override
  public boolean sleep(Location location, boolean force) {
    return false;
  }

  @Override
  public void wakeup(boolean setSpawnLocation) {

  }

  @Override
  public Location getBedLocation() {
    return null;
  }

  @Override
  public GameMode getGameMode() {
    return null;
  }

  @Override
  public void setGameMode(GameMode mode) {

  }

  @Override
  public boolean isBlocking() {
    return false;
  }

  @Override
  public double getEyeHeight() {
    return 0;
  }

  @Override
  public double getEyeHeight(boolean ignorePose) {
    return 0;
  }

  @Override
  public Location getEyeLocation() {
    return null;
  }

  @Override
  public List<Block> getLineOfSight(Set<Material> transparent, int maxDistance) {
    return null;
  }

  @Override
  public Block getTargetBlock(Set<Material> transparent, int maxDistance) {
    return null;
  }

  @Override
  public Block getTargetBlock(int maxDistance, TargetBlockInfo.FluidMode fluidMode) {
    return null;
  }

  @Override
  public BlockFace getTargetBlockFace(int maxDistance, TargetBlockInfo.FluidMode fluidMode) {
    return null;
  }

  @Override
  public TargetBlockInfo getTargetBlockInfo(int maxDistance, TargetBlockInfo.FluidMode fluidMode) {
    return null;
  }

  @Override
  public Entity getTargetEntity(int maxDistance, boolean ignoreBlocks) {
    return null;
  }

  @Override
  public TargetEntityInfo getTargetEntityInfo(int maxDistance, boolean ignoreBlocks) {
    return null;
  }

  @Override
  public List<Block> getLastTwoTargetBlocks(Set<Material> transparent, int maxDistance) {
    return null;
  }

  @Override
  public Block getTargetBlockExact(int maxDistance) {
    return null;
  }

  @Override
  public Block getTargetBlockExact(int maxDistance, FluidCollisionMode fluidCollisionMode) {
    return null;
  }

  @Override
  public RayTraceResult rayTraceBlocks(double maxDistance) {
    return null;
  }

  @Override
  public RayTraceResult rayTraceBlocks(double maxDistance, FluidCollisionMode fluidCollisionMode) {
    return null;
  }

  @Override
  public int getRemainingAir() {
    return 0;
  }

  @Override
  public void setRemainingAir(int ticks) {

  }

  @Override
  public int getMaximumAir() {
    return 0;
  }

  @Override
  public void setMaximumAir(int ticks) {

  }

  @Override
  public int getArrowCooldown() {
    return 0;
  }

  @Override
  public void setArrowCooldown(int ticks) {

  }

  @Override
  public int getArrowsInBody() {
    return 0;
  }

  @Override
  public void setArrowsInBody(int count) {

  }

  @Override
  public int getMaximumNoDamageTicks() {
    return 0;
  }

  @Override
  public void setMaximumNoDamageTicks(int ticks) {

  }

  @Override
  public double getLastDamage() {
    return 0;
  }

  @Override
  public void setLastDamage(double damage) {

  }

  @Override
  public int getNoDamageTicks() {
    return 0;
  }

  @Override
  public void setNoDamageTicks(int ticks) {

  }

  @Override
  public Player getKiller() {
    return null;
  }

  @Override
  public void setKiller(Player killer) {

  }

  @Override
  public boolean addPotionEffect(PotionEffect effect) {
    return false;
  }

  @Override
  public boolean addPotionEffect(PotionEffect effect, boolean force) {
    return false;
  }

  @Override
  public boolean addPotionEffects(Collection<PotionEffect> effects) {
    return false;
  }

  @Override
  public boolean hasPotionEffect(PotionEffectType type) {
    return false;
  }

  @Override
  public PotionEffect getPotionEffect(PotionEffectType type) {
    return null;
  }

  @Override
  public void removePotionEffect(PotionEffectType type) {

  }

  @Override
  public Collection<PotionEffect> getActivePotionEffects() {
    return null;
  }

  @Override
  public boolean hasLineOfSight(Entity other) {
    return false;
  }

  @Override
  public boolean hasLineOfSight(@NotNull Location location) {
    return false;
  }

  @Override
  public boolean getRemoveWhenFarAway() {
    return false;
  }

  @Override
  public void setRemoveWhenFarAway(boolean remove) {

  }

  @Override
  public EntityEquipment getEquipment() {
    return null;
  }

  @Override
  public void setCanPickupItems(boolean pickup) {

  }

  @Override
  public boolean getCanPickupItems() {
    return false;
  }

  @Override
  public boolean isLeashed() {
    return false;
  }

  @Override
  public Entity getLeashHolder() throws IllegalStateException {
    return null;
  }

  @Override
  public boolean setLeashHolder(Entity holder) {
    return false;
  }

  @Override
  public boolean isGliding() {
    return false;
  }

  @Override
  public void setGliding(boolean gliding) {

  }

  @Override
  public boolean isSwimming() {
    return false;
  }

  @Override
  public void setSwimming(boolean swimming) {

  }

  @Override
  public boolean isRiptiding() {
    return false;
  }

  @Override
  public boolean isSleeping() {
    return false;
  }

  @Override
  public void setAI(boolean ai) {

  }

  @Override
  public boolean hasAI() {
    return false;
  }

  @Override
  public void attack(Entity target) {

  }

  @Override
  public void swingMainHand() {

  }

  @Override
  public void swingOffHand() {

  }

  @Override
  public void setCollidable(boolean collidable) {

  }

  @Override
  public boolean isCollidable() {
    return false;
  }

  @Override
  public Set<UUID> getCollidableExemptions() {
    return null;
  }

  @Override
  public <T> T getMemory(MemoryKey<T> memoryKey) {
    return null;
  }

  @Override
  public <T> void setMemory(MemoryKey<T> memoryKey, T memoryValue) {

  }

  @Override
  public EntityCategory getCategory() {
    return null;
  }

  @Override
  public void setInvisible(boolean invisible) {

  }

  @Override
  public boolean isInvisible() {
    return false;
  }

  @Override
  public int getArrowsStuck() {
    return 0;
  }

  @Override
  public void setArrowsStuck(int arrows) {

  }

  @Override
  public int getShieldBlockingDelay() {
    return 0;
  }

  @Override
  public void setShieldBlockingDelay(int delay) {

  }

  @Override
  public ItemStack getActiveItem() {
    return null;
  }

  @Override
  public void clearActiveItem() {
    
  }

  @Override
  public int getItemUseRemainingTime() {
    return 0;
  }

  @Override
  public int getHandRaisedTime() {
    return 0;
  }

  @Override
  public boolean isHandRaised() {
    return false;
  }

  @Override
  public @NotNull EquipmentSlot getHandRaised() {
    return null;
  }

  @Override
  public boolean isJumping() {
    return false;
  }

  @Override
  public void setJumping(boolean jumping) {

  }

  @Override
  public void playPickupItemAnimation(Item item, int quantity) {

  }

  @Override
  public float getHurtDirection() {
    return 0;
  }

  @Override
  public void setHurtDirection(float hurtDirection) {

  }

  @Override
  public int getExpToLevel() {
    return 0;
  }

  @Override
  public Entity releaseLeftShoulderEntity() {
    return null;
  }

  @Override
  public Entity releaseRightShoulderEntity() {
    return null;
  }

  @Override
  public float getAttackCooldown() {
    return 0;
  }

  @Override
  public boolean discoverRecipe(NamespacedKey recipe) {
    return false;
  }

  @Override
  public int discoverRecipes(Collection<NamespacedKey> recipes) {
    return 0;
  }

  @Override
  public boolean undiscoverRecipe(NamespacedKey recipe) {
    return false;
  }

  @Override
  public int undiscoverRecipes(Collection<NamespacedKey> recipes) {
    return 0;
  }

  @Override
  public boolean hasDiscoveredRecipe(NamespacedKey recipe) {
    return false;
  }

  @Override
  public Set<NamespacedKey> getDiscoveredRecipes() {
    return null;
  }

  @Override
  public Entity getShoulderEntityLeft() {
    return null;
  }

  @Override
  public void setShoulderEntityLeft(Entity entity) {

  }

  @Override
  public Entity getShoulderEntityRight() {
    return null;
  }

  @Override
  public void setShoulderEntityRight(Entity entity) {

  }

  @Override
  public void openSign(Sign sign) {

  }

  @Override
  public boolean dropItem(boolean dropAll) {
    return false;
  }

  @Override
  public AttributeInstance getAttribute(Attribute attribute) {
    return null;
  }

  @Override
  public void registerAttribute(@NotNull Attribute attribute) {

  }

  @Override
  public void damage(double amount) {

  }

  @Override
  public void damage(double amount, Entity source) {

  }

  @Override
  public double getHealth() {
    return 0;
  }

  @Override
  public void setHealth(double health) {

  }

  @Override
  public double getAbsorptionAmount() {
    return 0;
  }

  @Override
  public void setAbsorptionAmount(double amount) {

  }

  @Override
  public double getMaxHealth() {
    return 0;
  }

  @Override
  public void setMaxHealth(double health) {

  }

  @Override
  public void resetMaxHealth() {

  }

  @Override
  public @Nullable Component customName() {
    return null;
  }

  @Override
  public void customName(@Nullable Component customName) {

  }

  @Override
  public String getCustomName() {
    return null;
  }

  @Override
  public void setCustomName(String name) {

  }

  @Override
  public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {

  }

  @Override
  public List<MetadataValue> getMetadata(String metadataKey) {
    return null;
  }

  @Override
  public boolean hasMetadata(String metadataKey) {
    return false;
  }

  @Override
  public void removeMetadata(String metadataKey, Plugin owningPlugin) {

  }

  @Override
  public boolean isPermissionSet(String name) {
    return false;
  }

  @Override
  public boolean isPermissionSet(Permission perm) {
    return false;
  }

  @Override
  public boolean hasPermission(String name) {
    return perms.containsKey(name) && perms.get(name);
  }

  @Override
  public boolean hasPermission(Permission perm) {
    return false;
  }

  @Override
  public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
    return null;
  }

  @Override
  public PermissionAttachment addAttachment(Plugin plugin) {
    return null;
  }

  @Override
  public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
    return null;
  }

  @Override
  public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
    return null;
  }

  @Override
  public void removeAttachment(PermissionAttachment attachment) {

  }

  @Override
  public void recalculatePermissions() {

  }

  @Override
  public Set<PermissionAttachmentInfo> getEffectivePermissions() {
    return null;
  }

  @Override
  public boolean isOp() {
    return false;
  }

  @Override
  public void setOp(boolean value) {

  }

  @Override
  public PersistentDataContainer getPersistentDataContainer() {
    return null;
  }

  @Override
  public void sendPluginMessage(Plugin source, String channel, byte[] message) {

  }

  @Override
  public Set<String> getListeningPluginChannels() {
    return null;
  }

  @Override
  public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
    return null;
  }

  @Override
  public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
    return null;
  }
}

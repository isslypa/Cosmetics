package org.neptune.cosmetics.listeners;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.neptune.cosmetics.cosmetics.TrailType;
import org.neptune.cosmetics.managers.ItemStackManager;
import org.neptune.cosmetics.managers.cosmetic.CosmeticMenu;
import org.neptune.cosmetics.managers.data.PlayerData;
import org.neptune.cosmetics.managers.trail.buttons.TrailButton;
import org.neptune.cosmetics.utilities.others.CC;

public class TrailListener implements Listener {
   @EventHandler
   private void onPlayerMove(PlayerMoveEvent event) {
      Player player = event.getPlayer();
      Location location1 = event.getFrom();
      Location location2 = event.getTo();
      if (location1.getBlockX() != location2.getBlockX() || location1.getBlockY() != location2.getBlockY() || location1.getBlockZ() != location2.getBlockZ()) {
         PlayerData data = new PlayerData(player.getUniqueId());
         if (data.getTrail() != null) {
            if (data.getTrail().equals(TrailType.HEART.getName())) {
               player.getWorld().spigot().playEffect(player.getLocation(), Effect.HEART, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getTrail().equals(TrailType.FLAME.getName())) {
               player.getWorld().spigot().playEffect(player.getLocation(), Effect.FLAME, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getTrail().equals(TrailType.SLIME.getName())) {
               player.getWorld().spigot().playEffect(player.getLocation(), Effect.SLIME, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getTrail().equals(TrailType.NOTE.getName())) {
               player.getWorld().spigot().playEffect(player.getLocation(), Effect.NOTE, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getTrail().equals(TrailType.CLOUD.getName())) {
               player.getWorld().spigot().playEffect(player.getLocation(), Effect.CLOUD, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getTrail().equals(TrailType.SMOKE.getName())) {
               player.getWorld().spigot().playEffect(player.getLocation(), Effect.LARGE_SMOKE, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getTrail().equals(TrailType.VILLAGER.getName())) {
               player.getWorld().spigot().playEffect(player.getLocation(), Effect.HAPPY_VILLAGER, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getTrail().equals(TrailType.CRITICAL.getName())) {
               player.getWorld().spigot().playEffect(player.getLocation(), Effect.MAGIC_CRIT, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getTrail().equals(TrailType.EXPLOSION.getName())) {
               player.getWorld().spigot().playEffect(player.getLocation(), Effect.EXPLOSION, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getTrail().equals(TrailType.FIREWORK.getName())) {
               player.getWorld().spigot().playEffect(player.getLocation(), Effect.FIREWORKS_SPARK, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getTrail().equals(TrailType.LAVA.getName())) {
               player.getWorld().spigot().playEffect(player.getLocation(), Effect.LAVADRIP, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getTrail().equals(TrailType.WATER.getName())) {
               player.getWorld().spigot().playEffect(player.getLocation(), Effect.WATERDRIP, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getTrail().equals(TrailType.SNOW.getName())) {
               player.getWorld().spigot().playEffect(player.getLocation(), Effect.SNOWBALL_BREAK, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getTrail().equals(TrailType.SPELL.getName())) {
               player.getWorld().spigot().playEffect(player.getLocation(), Effect.SPELL, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

         }
      }
   }

   @EventHandler
   private void onTrailClick(InventoryClickEvent event) {
      Player player = (Player) event.getWhoClicked();
      if (event.getClickedInventory() != null && event.getInventory() == event.getClickedInventory()) {
         if (event.getInventory().getTitle().equals("Trail")) {
            event.setCancelled(true);
            ItemStack stack = event.getCurrentItem();
            if (stack == null || stack.getType().equals(Material.AIR) || stack.getType().equals(Material.STAINED_GLASS_PANE)) {
               return;
            }

            if (TrailButton.getRemove(player).isSimilar(stack)) {
               PlayerData data = new PlayerData(player.getUniqueId());
               if (data.getTrail() == null) {
                  player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
                  player.sendMessage(CC.set("&cYou don't have any trail equipped."));
                  return;
               }

               data.setTrail(null);
               player.playSound(player.getLocation(), Sound.CLICK, 1.0F, 1.0F);
               player.closeInventory();
               player.sendMessage(CC.set("&aYour trail has been remove."));
               return;
            }

            if (ItemStackManager.getBack().isSimilar(stack)) {
               CosmeticMenu.getCosmetic(player);
               player.playSound(player.getLocation(), Sound.CLICK, 1.0F, 1.0F);
               return;
            }

            TrailType[] types = TrailType.values();

            for (TrailType type : types) {
               if (type.getItem(player).isSimilar(stack)) {
                  PlayerData data = new PlayerData(player.getUniqueId());
                  if (player.hasPermission("strong.cosmetics.trail." + type.getName().toLowerCase()) && player.hasPermission("strong.cosmetics.trail.*")) {
                     if (type.getName().equals(data.getTrail())) {
                        player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
                        player.sendMessage(CC.set("&cThis trail is already equipped."));
                        return;
                     }

                     data.setTrail(type.getName());
                     player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
                     player.closeInventory();
                     player.sendMessage(CC.set("&aSuccessfully equipped " + type.getDisplayName() + "&a."));
                     return;
                  }

                  player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
                  player.sendMessage(CC.set("&cYou don't have permissions to this trail."));
                  return;
               }
            }
         }

      }
   }
}

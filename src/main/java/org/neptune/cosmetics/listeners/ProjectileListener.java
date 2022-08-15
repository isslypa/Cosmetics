package org.neptune.cosmetics.listeners;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.neptune.cosmetics.cosmetics.TrailType;
import org.neptune.cosmetics.managers.ItemStackManager;
import org.neptune.cosmetics.managers.cosmetic.CosmeticMenu;
import org.neptune.cosmetics.managers.data.PlayerData;
import org.neptune.cosmetics.managers.projectile.buttons.ProjectileButton;
import org.neptune.cosmetics.utilities.others.CC;
public class ProjectileListener implements Listener {

    @Setter
    @Getter
    private Player player;

    @EventHandler
    private void onProjectileLaunch(ProjectileLaunchEvent event) {
        Arrow arrow = (Arrow) event.getEntity();
        arrow.getLocation();
        PlayerData data = new PlayerData(player.getUniqueId());
        if (data.getProjectile() != null) {
            if (data.getProjectile().equals(TrailType.HEART.getName())) {
                arrow.getWorld().spigot().playEffect(arrow.getLocation(), Effect.HEART, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getProjectile().equals(TrailType.FLAME.getName())) {
                arrow.getWorld().spigot().playEffect(arrow.getLocation(), Effect.FLAME, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getProjectile().equals(TrailType.SLIME.getName())) {
                arrow.getWorld().spigot().playEffect(arrow.getLocation(), Effect.SLIME, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getProjectile().equals(TrailType.NOTE.getName())) {
                arrow.getWorld().spigot().playEffect(arrow.getLocation(), Effect.NOTE, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getProjectile().equals(TrailType.CLOUD.getName())) {
                arrow.getWorld().spigot().playEffect(arrow.getLocation(), Effect.CLOUD, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getProjectile().equals(TrailType.SMOKE.getName())) {
                arrow.getWorld().spigot().playEffect(arrow.getLocation(), Effect.LARGE_SMOKE, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getProjectile().equals(TrailType.VILLAGER.getName())) {
                arrow.getWorld().spigot().playEffect(arrow.getLocation(), Effect.HAPPY_VILLAGER, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getProjectile().equals(TrailType.CRITICAL.getName())) {
                arrow.getWorld().spigot().playEffect(arrow.getLocation(), Effect.MAGIC_CRIT, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getProjectile().equals(TrailType.EXPLOSION.getName())) {
                player.getWorld().spigot().playEffect(player.getLocation(), Effect.EXPLOSION, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getProjectile().equals(TrailType.FIREWORK.getName())) {
                arrow.getWorld().spigot().playEffect(arrow.getLocation(), Effect.FIREWORKS_SPARK, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getProjectile().equals(TrailType.LAVA.getName())) {
                arrow.getWorld().spigot().playEffect(arrow.getLocation(), Effect.LAVADRIP, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getProjectile().equals(TrailType.WATER.getName())) {
                arrow.getWorld().spigot().playEffect(arrow.getLocation(), Effect.WATERDRIP, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getProjectile().equals(TrailType.SNOW.getName())) {
                arrow.getWorld().spigot().playEffect(arrow.getLocation(), Effect.SNOWBALL_BREAK, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

            if (data.getProjectile().equals(TrailType.SPELL.getName())) {
                arrow.getWorld().spigot().playEffect(arrow.getLocation(), Effect.SPELL, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
            }

        }
    }

    @EventHandler
    private void onProjectileClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory() != null && event.getInventory() == event.getClickedInventory()) {
            if (event.getInventory().getTitle().equals("Projectile")) {
                event.setCancelled(true);
                ItemStack stack = event.getCurrentItem();
                if (stack == null || stack.getType().equals(Material.AIR) || stack.getType().equals(Material.STAINED_GLASS_PANE)) {
                    return;
                }

                if (ProjectileButton.getRemove(player).isSimilar(stack)) {
                    PlayerData data = new PlayerData(player.getUniqueId());
                    if (data.getProjectile() == null) {
                        player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
                        player.sendMessage(CC.set("&cYou don't have any projectile equipped."));
                        return;
                    }

                    data.setProjectile(null);
                    player.playSound(player.getLocation(), Sound.CLICK, 1.0F, 1.0F);
                    player.closeInventory();
                    player.sendMessage(CC.set("&aYour projectile has been remove."));
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
                        if (player.hasPermission("cosmetics.projectile." + type.getName().toLowerCase()) && player.hasPermission("cosmetics.trail.*")) {
                            if (type.getName().equals(data.getProjectile())) {
                                player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
                                player.sendMessage(CC.set("&cThis projectile is already equipped."));
                                return;
                            }

                            data.setProjectile(type.getName());
                            player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
                            player.closeInventory();
                            player.sendMessage(CC.set("&aSuccessfully equipped " + type.getDisplayName() + "&a."));
                            return;
                        }

                        player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
                        player.sendMessage(CC.set("&cYou don't have permissions to this projectile."));
                        return;
                    }
                }
            }

        }
    }
}

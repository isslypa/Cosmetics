package org.neptune.cosmetics.managers.trail;

import org.neptune.cosmetics.Cosmetics;
import org.neptune.cosmetics.cosmetics.TrailType;
import org.neptune.cosmetics.managers.ItemStackManager;
import org.neptune.cosmetics.managers.trail.buttons.TrailButton;
import org.neptune.cosmetics.utilities.Helper;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.neptune.cosmetics.utilities.file.FileHandler;

public class TrailMenu {
   private static final FileHandler config = Cosmetics.getInstance().getConfig();
   public static void getTrail(Player player) {
      Inventory inventory = Bukkit.createInventory(null, 36, "Trail");
      inventory.setItem(10, TrailType.HEART.getItem(player));
      inventory.setItem(11, TrailType.FLAME.getItem(player));
      inventory.setItem(12, TrailType.SLIME.getItem(player));
      inventory.setItem(13, TrailType.NOTE.getItem(player));
      inventory.setItem(14, TrailType.CLOUD.getItem(player));
      inventory.setItem(15, TrailType.SMOKE.getItem(player));
      inventory.setItem(16, TrailType.VILLAGER.getItem(player));
      inventory.setItem(19, TrailType.CRITICAL.getItem(player));
      inventory.setItem(20, TrailType.EXPLOSION.getItem(player));
      inventory.setItem(21, TrailType.FIREWORK.getItem(player));
      inventory.setItem(22, TrailType.LAVA.getItem(player));
      inventory.setItem(23, TrailType.WATER.getItem(player));
      inventory.setItem(24, TrailType.SNOW.getItem(player));
      inventory.setItem(25, TrailType.SPELL.getItem(player));
      inventory.setItem(30, ItemStackManager.getBack());
      inventory.setItem(31, TrailButton.getRemove(player));
      if (config.getBoolean("FILL-MENUS")) {
         Helper.getFill(inventory);
      }

      player.openInventory(inventory);
   }
}

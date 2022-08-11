package org.neptune.cosmetics.managers.cosmetic;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.neptune.cosmetics.Cosmetics;
import org.neptune.cosmetics.managers.cosmetic.buttons.CosmeticButton;
import org.neptune.cosmetics.utilities.Helper;
import org.neptune.cosmetics.utilities.file.FileHandler;
import org.neptune.cosmetics.utilities.others.CC;

public class CosmeticMenu {
   private static final FileHandler menu = Cosmetics.getInstance().getMenu();
   private static final FileHandler config = Cosmetics.getInstance().getConfig();
   public static void getCosmetic(Player player) {
      Inventory inventory = Bukkit.createInventory(null, menu.getInt("COSMETICS.SIZE") * 9, CC.set(menu.getString("COSMETICS.TITLE")));
      inventory.setItem(menu.getInt("COSMETICS.TRAIL.SLOT") - 1, CosmeticButton.getTrail());
      if (config.getBoolean("FILL-MENUS")) {
         Helper.getFill(inventory);
      }

      player.openInventory(inventory);
   }
}

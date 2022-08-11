package org.neptune.cosmetics.managers.cosmetic.buttons;

import org.bukkit.inventory.ItemStack;
import org.neptune.cosmetics.Cosmetics;
import org.neptune.cosmetics.utilities.file.FileHandler;
import org.neptune.cosmetics.utilities.item.ItemCreator;

public class CosmeticButton {
   private static final FileHandler menu = Cosmetics.getInstance().getMenu();

   public static ItemStack getTrail() {
      return (new ItemCreator(menu.getString("COSMETICS.TRAIL.ITEM.MATERIAL"))).setDurability(menu.getInt("COSMETICS.TRAIL.ITEM.DATA")).setName(menu.getString("COSMETICS.TRAIL.NAME")).setLore(menu.getStringList("COSMETICS.TRAIL.LORE")).setGlow(menu.getBoolean("COSMETICS.TRAIL.ITEM.GLOW")).get();
   }
}

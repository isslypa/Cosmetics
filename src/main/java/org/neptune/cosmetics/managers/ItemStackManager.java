package org.neptune.cosmetics.managers;

import org.neptune.cosmetics.Cosmetics;
import org.neptune.cosmetics.utilities.file.FileHandler;
import org.neptune.cosmetics.utilities.item.ItemCreator;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemStackManager {
   private static final FileHandler config = Cosmetics.getInstance().getConfig();

   public static ItemStack getFill() {
      return (new ItemCreator(config.getString("FILL-ITEM.MATERIAL"))).setDurability(config.getInt("FILL-ITEM.DATA")).setName(config.getString("FILL-ITEM.NAME")).get();
   }

   public static ItemStack getBack() {
      return (new ItemCreator(Material.ARROW)).setName("&7Back").get();
   }
}

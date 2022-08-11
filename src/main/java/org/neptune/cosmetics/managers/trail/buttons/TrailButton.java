package org.neptune.cosmetics.managers.trail.buttons;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.neptune.cosmetics.Cosmetics;
import org.neptune.cosmetics.managers.data.PlayerData;
import org.neptune.cosmetics.utilities.file.FileHandler;
import org.neptune.cosmetics.utilities.item.ItemCreator;

public class TrailButton {
   private static final FileHandler menu = Cosmetics.getInstance().getMenu();
   public static ItemStack getRemove(Player player) {
      PlayerData data = new PlayerData(player.getUniqueId());
         return (new ItemCreator(menu.getString("COSMETICS.TRAIL.BUTTON.ITEM.MATERIAL")).setName(menu.getString("COSMETICS.TRAIL.BUTTON.NAME")).setLore(menu.getStringList("COSMETICS.TRAIL.BUTTON.LORE") + (data.getTrail() == null ? "None" : data.getTrail())).get());
         //Hay que hacer una variable para (data.getTrail() == null ? "None" : data.getTrail()) llamada %ACTIVE_TRAILS%". esto es para el lore.
      }
}

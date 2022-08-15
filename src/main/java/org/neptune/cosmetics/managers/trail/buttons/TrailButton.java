package org.neptune.cosmetics.managers.trail.buttons;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.neptune.cosmetics.Cosmetics;
import org.neptune.cosmetics.managers.data.PlayerData;
import org.neptune.cosmetics.utilities.file.FileHandler;
import org.neptune.cosmetics.utilities.item.ItemCreator;

import java.util.ArrayList;
import java.util.List;

public class TrailButton {
   private static final FileHandler menu = Cosmetics.getInstance().getMenu();
   public static ItemStack getRemove(Player player) {
      PlayerData data = new PlayerData(player.getUniqueId());
      List<String> list = new ArrayList<>();
      String texto = "pene";
      texto.replace("pene", "2");
      for(String text : menu.getStringList("COSMETICS.TRAIL.BUTTON.LORE"))
      {
         text.replace("%ACTIVE_TRAILS%", data.getTrail() == null ? "None" : data.getTrail());
         list.add(text);
      }

         return (new ItemCreator(menu.getString("COSMETICS.TRAIL.BUTTON.ITEM.MATERIAL")).setName(menu.getString("COSMETICS.TRAIL.BUTTON.NAME")).setLore(list).get());
      }
}

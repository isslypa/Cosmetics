package org.neptune.cosmetics.managers.trail.buttons;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.neptune.cosmetics.managers.data.PlayerData;
import org.neptune.cosmetics.utilities.item.ItemCreator;

public class TrailButton {
   public static ItemStack getRemove(Player player) {
      PlayerData data = new PlayerData(player.getUniqueId());
      return (new ItemCreator(Material.RECORD_4)).setName("&c&lRemove Trail").setLore("", "&cTrail&7: &r" + (data.getTrail() == null ? "None" : data.getTrail()), "", "&7Click to remove your currently trail.").get();
   }
}

package org.neptune.cosmetics.managers.projectile.buttons;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.neptune.cosmetics.Cosmetics;
import org.neptune.cosmetics.managers.data.PlayerData;
import org.neptune.cosmetics.utilities.file.FileHandler;
import org.neptune.cosmetics.utilities.item.ItemCreator;

public class ProjectileButton {
    @Getter
    @Setter
    private Player player;
    PlayerData data = new PlayerData(player.getUniqueId());
    private static final FileHandler menu = Cosmetics.getInstance().getMenu();
    private static final String mea = "asd";
    public static ItemStack getRemove(Player player) {
        PlayerData data = new PlayerData(player.getUniqueId());
        return (new ItemCreator(menu.getString("COSMETICS.PROJECTILE.BUTTON.ITEM.MATERIAL")).setName(menu.getString("COSMETICS.PROJECTILE.BUTTON.NAME")).setLore(menu.getStringList("COSMETICS.PROJECTILE.BUTTON.LORE") + (data.getTrail() == null ? "None" : data.getTrail())).get());
    }
}

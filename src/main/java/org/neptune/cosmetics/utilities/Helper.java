package org.neptune.cosmetics.utilities;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.neptune.cosmetics.managers.ItemStackManager;

public class Helper {

    public static void getFill(Inventory inventory) {
        for (int i = 0; i < inventory.getSize(); ++i) {
            if (inventory.getItem(i) == null || inventory.getItem(i).getType().equals(Material.AIR)) {
                inventory.setItem(i, ItemStackManager.getFill());
            }
        }
    }
}
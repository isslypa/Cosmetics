package org.neptune.cosmetics.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.neptune.cosmetics.Cosmetics;
import org.neptune.cosmetics.managers.cosmetic.buttons.CosmeticButton;
import org.neptune.cosmetics.managers.trail.TrailMenu;
import org.neptune.cosmetics.utilities.file.FileHandler;
import org.neptune.cosmetics.utilities.others.CC;

public class CosmeticListener implements Listener {
   private static final FileHandler menu = Cosmetics.getInstance().getMenu();
   @EventHandler
   public void onCosmeticClick(InventoryClickEvent event) {
      Player player = (Player)event.getWhoClicked();
      if (event.getClickedInventory() != null && event.getInventory() == event.getClickedInventory()) {
         if (event.getInventory().getTitle().equals(CC.set(menu.getString("COSMETICS.TITLE")))) {
            event.setCancelled(true);
            ItemStack stack = event.getCurrentItem();
            if (stack == null || stack.getType().equals(Material.AIR) || stack.getType().equals(Material.STAINED_GLASS_PANE)) {
               return;
            }

            if (CosmeticButton.getTrail().isSimilar(stack)) {
               TrailMenu.getTrail(player);
            }

            player.playSound(player.getLocation(), Sound.CLICK, 1.0F, 1.0F);
         }

      }
   }
}

package org.neptune.cosmetics.cosmetics;

import org.neptune.cosmetics.Cosmetics;
import org.neptune.cosmetics.managers.data.PlayerData;
import java.beans.ConstructorProperties;
import java.util.Arrays;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.neptune.cosmetics.utilities.file.FileHandler;
import org.neptune.cosmetics.utilities.item.ItemCreator;
import org.neptune.cosmetics.utilities.others.CC;

public enum TrailType {
   
   SMOKE("Smoke", "&7Smoke", Material.FIREBALL, 0),
   SNOW("Snow", "&fSnow", Material.SNOW, 0),
   EXPLOSION("Explosion", "&4Explosion", Material.TNT, 0),
   SLIME("Slime", "&aSlime", Material.SLIME_BALL, 0),
   LAVA("Lava", "&6Lava", Material.LAVA_BUCKET, 0),
   VILLAGER("Villager", "&aVillager", Material.EMERALD, 0),
   FIREWORK("Firework", "&fFirework", Material.FIREWORK, 0),
   HEART("Heart", "&4Heart", Material.REDSTONE, 0),
   WATER("Water", "&9Water", Material.WATER_BUCKET, 0),
   NOTE("Note", "&9Note", Material.NOTE_BLOCK, 0),
   CRITICAL("Critical", "&5Critical", Material.ENCHANTMENT_TABLE, 0),
   FLAME("Flame", "&6Flame", Material.BLAZE_POWDER, 0),
   SPELL("Spell", "&bSpell", Material.POTION, 0),
   CLOUD("Cloud", "&fCloud", Material.WEB, 0);

   private final String name;
   private final String displayName;
   private final Material material;
   private final int data;
   public String getName() {
      return this.name;
   }

   private static final FileHandler config = Cosmetics.getInstance().getConfig();
   private static final FileHandler lang = Cosmetics.getInstance().getLang();
   public String getDisplayName() {
      return CC.set(this.displayName);
   }

   @ConstructorProperties({"name", "displayName", "material", "data"})
   TrailType(String name, String displayName, Material material, int data) {
      this.name = name;
      this.displayName = displayName;
      this.material = material;
      this.data = data;
   }

   public ItemStack getItem(Player player) {
      PlayerData data = new PlayerData(player.getUniqueId());
      ItemCreator creator = new ItemCreator(this.getMaterial());
      creator.setDurability(this.getData());
      creator.setName(this.getDisplayName() + " Trail");
      creator.setLore(Arrays.asList("", "&aClick to equip this trail."));
      if (!player.hasPermission("cosmetics.trail." + this.getName().toLowerCase())) {
         creator.setLore(Arrays.asList("", "&cYou don't have permission to this trail.", "&cPurchase at " + lang.getString("STORE")));
      }

      if (this.getName().equals(data.getTrail())) {
         creator.setLore(Arrays.asList("", "&aEquipped."));
      }

      return creator.get();
   }

   public int getData() {
      return this.data;
   }

   public Material getMaterial() {
      return this.material;
   }
}

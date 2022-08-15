package org.neptune.cosmetics.managers.data;

import org.neptune.cosmetics.Cosmetics;
import org.neptune.cosmetics.utilities.file.FileHandler;

import java.util.UUID;

public class PlayerData {
   private static final FileHandler data = Cosmetics.getInstance().getData();
   private final UUID uuid;

   public PlayerData(UUID uuid) {
      this.uuid = uuid;
   }

   public void setTrail(String input) {
      data.set("DATA." + this.uuid + ".TRAIL", input);
      data.save();
   }

   public String getTrail() {
      return data.getString("DATA." + this.uuid + ".TRAIL");
   }

   public void setProjectile(String input) {
      data.set("DATA." + this.uuid + ".PROJECTILE", input);
      data.save();
   }
   public String getProjectile() {
      return data.getString("DATA." + this.uuid + ".PROJECTILE");
   }
}

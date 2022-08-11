package org.neptune.cosmetics.managers.data;

import org.neptune.cosmetics.Cosmetics;
import org.neptune.cosmetics.utilities.file.FileHandler;

import java.util.UUID;

public class PlayerData {
   private static final FileHandler data = Cosmetics.getInstance().getData();
   private final UUID uuid;


   public void setTrail(String input) {
      data.set("DATA." + this.uuid + ".TRAIL", input);
      data.save();
   }

   public PlayerData(UUID uuid) {
      this.uuid = uuid;
   }

   public String getTrail() {
      return data.getString("DATA." + this.uuid + ".TRAIL");
   }
}

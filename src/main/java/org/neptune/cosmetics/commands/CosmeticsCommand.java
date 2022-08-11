package org.neptune.cosmetics.commands;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.neptune.cosmetics.managers.cosmetic.CosmeticMenu;
import org.neptune.cosmetics.utilities.commands.BaseCommand;
import org.neptune.cosmetics.utilities.commands.Command;
import org.neptune.cosmetics.utilities.commands.CommandArgs;

public class CosmeticsCommand extends BaseCommand {

    @Command(name = "Cosmetics", permission = "cosmetics.admin", aliases = {"cmc", "cosm"}, inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        CosmeticMenu.getCosmetic(player);
        player.updateInventory();
        player.playSound(player.getLocation(), Sound.CLICK, 1.0F, 1.0F);
}
}

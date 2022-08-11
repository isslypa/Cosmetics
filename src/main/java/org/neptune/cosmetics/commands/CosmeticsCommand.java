package org.neptune.cosmetics.commands;

import org.bukkit.command.CommandSender;
import org.neptune.cosmetics.Cosmetics;
import org.neptune.cosmetics.utilities.commands.BaseCommand;
import org.neptune.cosmetics.utilities.commands.Command;
import org.neptune.cosmetics.utilities.commands.CommandArgs;
import org.neptune.cosmetics.utilities.others.CC;

public class CosmeticsCommand extends BaseCommand {

    @Command(name = "Cosmetics", permission = "cosmetics.admin", aliases = {"cmc", "cosm"}, inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        String[] args = command.getArgs();

        if (args.length == 0) {
            sender.sendMessage(CC.translate(""));
            sender.sendMessage(CC.translate("&d&lCosmetics by Neptune Development &7- &f"+ (Cosmetics.getInstance().getDescription().getVersion())));
            sender.sendMessage(CC.translate(""));
            sender.sendMessage(CC.translate("&7/cosmetics version"));
            sender.sendMessage(CC.translate("&7/cosmetics reload"));
            sender.sendMessage(CC.translate(""));
            return;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            Cosmetics.getInstance().getConfig().reload();
            Cosmetics.getInstance().getLang().reload();
            Cosmetics.getInstance().getMenus().reload();
            sender.sendMessage(CC.translate("&aConfigs has been reloaded."));
            return;
        }

        if (args[0].equalsIgnoreCase("version")) {
            sender.sendMessage(CC.translate("&d&lCosmetics by Neptune Development. &7- &f" + (Cosmetics.getInstance().getDescription().getVersion())));

        }
    }
}
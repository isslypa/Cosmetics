package org.neptune.cosmetics.utilities.others;

import lombok.experimental.UtilityClass;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.neptune.cosmetics.Cosmetics;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CC {

    public String LONG_LINE = "&7&m----------------------------------------";
    public String NORMAL_LINE = "&7&m-----------------------------";
    public String SHORT_LINE = "&7&m---------------";

    public String translate(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public List<String> translate(List<String> list) {
        return list.stream().map(CC::translate).collect(Collectors.toList());
    }

    public static List<String> lore(List<String> input) {
        return input.stream().map(CC::set).collect(Collectors.toList());
    }

    public static String set(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
    public String strip(String text) {
        return ChatColor.stripColor(text);
    }

    public void sender(CommandSender sender, String text) {
        sender.sendMessage(translate(text));
    }

    public void message(Player player, String text) {
        player.sendMessage(translate(text));
    }

    public void broadcast(String text) {
        Bukkit.broadcastMessage(translate(text));
    }

    public void log(String text) {
        Bukkit.getConsoleSender().sendMessage(translate(text));
    }

    public static String translate(Player player, String text, boolean colorized) {
        return placeholder(player, text, Cosmetics.isPlaceholderAPI(), colorized);
    }

    public static String placeholder(Player player, String text, boolean isPlaceholderAPI, boolean colorized) {
        if (colorized) {
            return translate( isPlaceholderAPI ? PlaceholderAPI.setPlaceholders(player, text) : text);
        } else {
            return isPlaceholderAPI ? PlaceholderAPI.setPlaceholders(player, text) : text;
        }
    }

}

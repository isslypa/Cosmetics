package org.neptune.cosmetics;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.neptune.cosmetics.commands.CosmeticsCommand;
import org.neptune.cosmetics.commands.admin.AdminCosmeticsCommand;
import org.neptune.cosmetics.listeners.CosmeticListener;
import org.neptune.cosmetics.listeners.TrailListener;
import org.neptune.cosmetics.utilities.commands.CommandManager;
import org.neptune.cosmetics.utilities.file.FileHandler;
import org.neptune.cosmetics.utilities.others.CC;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Cosmetics extends JavaPlugin {

    @Getter
    private static Cosmetics instance;
    @Getter
    private static boolean isPlaceholderAPI = false;
    private FileHandler config, lang, data, menu;
    private CommandManager commandManager;

    @Override
    public void onEnable() {
        instance = this;
        this.loadFiles();
        this.loadManager();
        CC.log("&aActivating Cosmetics by Neptune Development...");
        this.loadListeners();
        this.loadCommands();
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            isPlaceholderAPI = true;
        }
    }
    public void onDisable(){
        CC.log("&4Disabling Cosmetics.");
    }
        private void loadFiles() {
            this.config = new FileHandler(this, "config.yml", true);
            this.lang = new FileHandler(this, "lang.yml", true);
            this.data = new FileHandler(this, "data/data.yml", true);
            this.menu = new FileHandler(this, "menu/cosmetics.yml", true);
        }
        private void loadManager(){
            this.commandManager = new CommandManager(this);
        }
        private void loadListeners(){
            List<Listener> listeners = Arrays.asList(
                    new CosmeticListener(),
                    new TrailListener());
            for (Listener listener : listeners) {
                Bukkit.getPluginManager().registerEvents(listener, this);
            }

            CC.log("&dLoaded &f" + listeners.size() + " &dlisteners.");
        }
        private void loadCommands() {
            List<Object> commands;
            commands = Arrays.asList(
                    new CosmeticsCommand(),
                    new AdminCosmeticsCommand()

            );
            for (Object object : commands) {
                this.commandManager.registerCommands(object, Lists.newArrayList());
            }

            CC.log("&dLoaded &f" + commands.size() + " &dcommands.");
        }
    }

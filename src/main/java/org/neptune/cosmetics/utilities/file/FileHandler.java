package org.neptune.cosmetics.utilities.file;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class FileHandler extends YamlConfiguration {

    private final Plugin plugin;
    private final String name;
    private final Boolean parent;
    private File file;

    public FileHandler(Plugin plugin, String name, Boolean parent) {
        this.plugin = plugin;
        this.name = name;
        this.parent = parent;
        this.reload();
    }

    public void reload() {
        try {
            this.file = new File(this.plugin.getDataFolder(), this.name);
            if (!this.file.exists() && this.parent) this.createParent();
            if (!(this.file.exists()) && this.parent) this.createFile();
            this.load(this.file);
        } catch (IOException | InvalidConfigurationException ex) {
            this.plugin.getLogger().severe("[FileHandler] File " + this.name + " could not be loaded. Reason " + ex.getMessage());
        }
    }

    public void save() {
        try {
            this.save(this.file);
        } catch (IOException ex) {
            this.plugin.getLogger().severe("[FileHandler] File " + this.name + " could not be saved. Reason " + ex.getMessage());
        }
    }

    void createParent() throws IOException {
        this.file.getParentFile().mkdir();
        if (this.plugin.getResource(this.name) != null) this.plugin.saveResource(this.name, false);
        this.createFile();
    }

    void createFile() throws IOException {
        this.file.createNewFile();
    }
}

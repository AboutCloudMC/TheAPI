package de.aboutcloud.theapi.api;

import de.aboutcloud.theapi.TheAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FileAPI {

    private String path;
    private File file;
    private FileConfiguration config;

    public FileAPI(String path) {
        this.path = path;
        this.file = new File(this.path);
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }

    public void addDefault(String key, String value) {
            this.config.options().copyDefaults(true);
            this.config.addDefault(key, value);
            save();
    }

    public void save() {
        try {
            this.config.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public FileConfiguration getConfig() {
        return config;
    }
}

package de.aboutcloud.theapi;

import de.aboutcloud.theapi.api.FileAPI;
import de.aboutcloud.theapi.api.SQLAPI;
import de.aboutcloud.theapi.testing.listener.JoinListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class TheAPI extends JavaPlugin {

    private static TheAPI instance;

    @Override
    public void onEnable() {
        instance = this;

        //Testing

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static TheAPI getInstance() {
        return instance;
    }
}

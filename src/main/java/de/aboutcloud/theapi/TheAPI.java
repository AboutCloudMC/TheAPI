package de.aboutcloud.theapi;

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

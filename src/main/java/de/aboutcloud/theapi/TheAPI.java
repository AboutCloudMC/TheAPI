package de.aboutcloud.theapi;

import de.aboutcloud.theapi.api.FileAPI;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class TheAPI extends JavaPlugin {

    private static TheAPI instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {

    }

    public static TheAPI getInstance() {
        return instance;
    }
}

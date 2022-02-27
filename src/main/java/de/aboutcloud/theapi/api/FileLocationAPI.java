package de.aboutcloud.theapi.api;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class FileLocationAPI {

    public static Location load(FileConfiguration cfg, String path) {
        World world = Bukkit.getWorld(cfg.getString(path + ".World"));
        double x = cfg.getDouble(path + ".X");
        double y = cfg.getDouble(path + ".Y");
        double z = cfg.getDouble(path + ".Z");
        float yaw = (float) cfg.getDouble(path + ".Yaw");
        float pitch = (float) cfg.getDouble(path + ".Pitch");
        return new Location(world, x, y, z, yaw, pitch);
    }

    public static Location loadBlock(FileConfiguration cfg, String path) {
        World world = Bukkit.getWorld(cfg.getString(path + ".World"));
        double x = cfg.getDouble(path + ".X");
        double y = cfg.getDouble(path + ".Y");
        double z = cfg.getDouble(path + ".Z");
        return new Location(world, x, y, z);
    }

    public static void save(Location location, FileConfiguration cfg, File file, String path) {
        try {
            cfg.set(path + ".World", location.getWorld());
            cfg.set(path + ".X", location.getX());
            cfg.set(path + ".Y", location.getY());
            cfg.set(path + ".Z", location.getZ());
            cfg.set(path + ".Yaw", location.getYaw());
            cfg.set(path + ".Pitch", location.getPitch());
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveBlock(Location location, FileConfiguration cfg, File file, String path) {
        try {
            cfg.set(path + ".World", location.getWorld());
            cfg.set(path + ".X", location.getBlockX());
            cfg.set(path + ".Y", location.getBlockY());
            cfg.set(path + ".Z", location.getBlockZ());
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

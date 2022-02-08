package de.aboutcloud.theapi.api;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.UUID;

public class ItemAPI {

    private ItemStack item;
    private ItemMeta meta;

    public ItemAPI(Material material, int count) {
        this.item = new ItemStack(material, count);
        this.meta = this.item.getItemMeta();
    }

    public ItemAPI setName(String name) {
        meta.setDisplayName(name);
        return this;
    }

    public ItemAPI setLore(String... lore) {
        meta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemAPI addEnchantment(Enchantment ench, int level) {
        meta.addEnchant(ench, level, true);
        return this;
    }

    public ItemAPI setUnbreakable(boolean unbreakable) {
        meta.setUnbreakable(unbreakable);
        return this;
    }

    public ItemAPI setFlag(ItemFlag flag) {
        meta.addItemFlags(flag);
        return this;
    }

    public ItemAPI setSkullOwner(UUID uuid) {
        SkullMeta skullMeta = (SkullMeta) meta;
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(uuid));
        return this;
    }

    public ItemStack build() {
        this.item.setItemMeta(this.meta);
        return this.item;
    }
}

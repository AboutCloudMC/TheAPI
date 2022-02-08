package de.aboutcloud.theapi.testing;

import de.aboutcloud.theapi.TheAPI;
import de.aboutcloud.theapi.scoreboard.AnimatedScoreboard;
import de.aboutcloud.theapi.scoreboard.TheScoreboard;
import net.kyori.adventure.text.Component;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.model.data.DataType;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.PrefixNode;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Set;
import java.util.stream.Collectors;

public class TestScoreboard extends TheScoreboard {

    private final String displayName;
    private char[] chars;
    private String current;
    private int index;

    public TestScoreboard(Player player) {
        super(player, ChatColor.RED.toString() + "KlingKlang");
        this.displayName = getDisplayName();
        this.chars = displayName.toCharArray();
        this.current = "";
        this.index = 0;
    }

    @Override
    public void createScoreboard() {
        User lpUser = LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId());
        CachedMetaData metaData = LuckPermsProvider.get().getGroupManager().getGroup(lpUser.getPrimaryGroup()).getCachedData().getMetaData();

        setScore(ChatColor.DARK_GRAY.toString(), 15);
        setScore(" §7Dein Rang:", 14);
        setScore("   " + ChatColor.translateAlternateColorCodes('&', metaData.getPrefix()), 13);
        setScore(ChatColor.GRAY.toString(), 12);
        setScore(" §7Coins:", 11);
        setScore("   §e1000", 10);
        setScore(ChatColor.RED.toString(), 9);
        setScore(" §7Discord:", 8);
        setScore("   §9jdidjfD", 7);
        setScore(ChatColor.AQUA.toString(), 6);
    }

    @Override
    public void update() {

    }

    public void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                current = current + chars[index];
                setDisplayName(current);
                index++;
                if(index >= displayName.length()) {
                    index = 0;
                    current = "";
                }
            }
        }.runTaskTimer(TheAPI.getInstance(), 20, 20);
    }
}

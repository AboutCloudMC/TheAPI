package de.aboutcloud.theapi.testing.listener;

import de.aboutcloud.theapi.TheAPI;
import de.aboutcloud.theapi.testing.TestScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    private TheAPI api;

    public JoinListener(TheAPI api) {
      this.api = api;
      Bukkit.getPluginManager().registerEvents(this, this.api);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        new TestScoreboard(e.getPlayer());

        /*PacketContainer packet = new PacketContainer(PacketType.Play.Server.EXPLOSION);
        packet.getDoubles()
                .write(0, e.getPlayer().getLocation().getX())
                .write(1, e.getPlayer().getLocation().getY())
                .write(2, e.getPlayer().getLocation().getZ());*/
    }
}

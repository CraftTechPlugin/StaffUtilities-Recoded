package it.crafttechplugin.staffutilities.listeners;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Color;
import it.crafttechplugin.staffutilities.Utils.Message;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        String getGameMode = Main.getInstance().getConfig().getString("gamemode-on-join");
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        if(getGameMode == "survival"){
            p.setGameMode(GameMode.SURVIVAL);
        } else if(getGameMode == "creative") {
            p.setGameMode(GameMode.CREATIVE);
        } else if (getGameMode == "spectator") {
            p.setGameMode(GameMode.SPECTATOR);
        } else if (getGameMode == "adventure") {
            p.setGameMode(GameMode.ADVENTURE);
        }

        //Join Message & Fly
        if (Main.getInstance().getConfig().getBoolean("join-message.Enabled")) {
            String Senza = Color.getColor(Message.JOIN_MESSAGE.toString()).replaceAll("%player%", p.getName());
            String Con = PlaceholderAPI.setPlaceholders(p, Senza);
            e.setJoinMessage(Color.getColor(Con));
        }else if(p.hasPermission("staffutilities.fly")) {
            if (Main.getInstance().getConfig().getBoolean("join-fly")) {
                p.setAllowFlight(true);
            }
        }
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
    }
}
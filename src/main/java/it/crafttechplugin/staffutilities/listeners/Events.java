package it.crafttechplugin.staffutilities.listeners;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Color;
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
        FileConfiguration msg = Main.msg;
        Player p = e.getPlayer();
        p.setGameMode(GameMode.SURVIVAL);
        e.setJoinMessage(null);
        if (Main.getInstance().getConfig().getBoolean("join-message.Enabled")) {
            String Senza = Color.getColor(Main.getInstance().getConfig().getString("Messages.JoinMessage.Message")).replaceAll("%player%", p.getName());
            String Con = PlaceholderAPI.setPlaceholders(p, Senza);
            e.setJoinMessage(Color.getColor(Con));
        }else if(p.hasPermission("staffutilities.fly")){
            if(Main.getInstance().getConfig().getBoolean("join-fly")){
                p.setAllowFlight(true);
            }
        }
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
    }
}
package it.crafttechplugin.staffutilities.Events;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;

public class Events implements Listener {
    private File msgf;
    private FileConfiguration msg;


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.setGameMode(GameMode.SURVIVAL);
        e.setJoinMessage(null);
        if (Main.getInstance().getConfig().getBoolean("Messages.JoinMessage.Enabled")) {
            String Senza = ColorTranslateUtil.getColor(Main.getInstance().getConfig().getString("Messages.JoinMessage.Message")).replaceAll("%player%", p.getName());
            String Con = PlaceholderAPI.setPlaceholders(p, Senza);
            e.setJoinMessage(ColorTranslateUtil.getColor(Con));
        }else if(p.hasPermission("staffutilities.fly")){
            p.setAllowFlight(true);
        }
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
    }
}
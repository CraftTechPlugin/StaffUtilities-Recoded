package it.gramdeveloment.staffutilities.Events;

import it.gramdeveloment.staffutilities.Main;
import it.gramdeveloment.staffutilities.Utils.ColorTranslateUtil;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.setGameMode(GameMode.SURVIVAL);
        e.setJoinMessage(null);
        if (Main.getInstance().getConfig().getBoolean("Messages.JoinMessage.Enabled")) {
            String Senza = ColorTranslateUtil.getColor(Main.getInstance().getConfig().getString("Messages.JoinMessage.Message")).replaceAll("%player%", p.getName());
            String Con = PlaceholderAPI.setPlaceholders(p, Senza);
            e.setJoinMessage(ColorTranslateUtil.getColor(Con));
        }else if(p.hasPermission("staffutilities.fly") || p.hasPermission("staffutilities.*")){
            p.setAllowFlight(true);
        }
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
    }
}
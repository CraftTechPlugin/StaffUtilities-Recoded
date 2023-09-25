package it.crafttechplugin.staffutilities.listeners;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.UUID;

@SuppressWarnings("all")
public class PlayerChat implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();

        Main.getInstance().muteManager.checkDuration(uuid);

        if(Main.getInstance().muteManager.isMuted(uuid)) {
            e.setCancelled(true);
            if(Main.getInstance().muteManager.getTimeLeft(uuid).equalsIgnoreCase("§cPermanent")) {
                player.sendMessage("§cYou are permanently muted");
            } else {
                player.sendMessage("§cYou are muted for §e" + Main.getInstance().muteManager.getTimeLeft(uuid));
            }
        }
    }

    @EventHandler
    public void onMessage(PlayerChatEvent e){
        String msg = e.getMessage();
        e.setMessage(Color.getColor(msg));
    }

}
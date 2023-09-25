package it.crafttechplugin.staffutilities.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import it.crafttechplugin.staffutilities.Main;

public class PLHider implements Listener {

    private FileConfiguration msg = Main.msg;
    private FileConfiguration config = Main.config;

    @EventHandler
    public void OnPluginCommand(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().equals("/pl") || e.getMessage().equals("/plugins")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(msg.getString("Message.PLHider"));
        }
    }

}

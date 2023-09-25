package it.crafttechplugin.staffutilities.listeners;

import it.crafttechplugin.staffutilities.Utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import static it.crafttechplugin.staffutilities.Commands.SpyCommand.spylogs;
import static it.crafttechplugin.staffutilities.Main.msg;
public class SpyLogs implements Listener {

    @EventHandler
    public void onmsg(PlayerCommandPreprocessEvent e){
        if(e.getMessage().startsWith("/msg") || e.getMessage().startsWith("/w") || e.getMessage().startsWith("/r")){
            for(Player people : Bukkit.getOnlinePlayers()){
                if(spylogs.contains(people)){
                    people.sendMessage(Color.getColor(msg.getString("Messages.SpyPrefix") + e.getMessage()));
                }
            }
        }
    }
}

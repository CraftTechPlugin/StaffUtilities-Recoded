package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PLHider implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        if(event.getMessage().startsWith("/pl") ||
           event.getMessage().startsWith("/bukkit:pl") ||
           event.getMessage().startsWith("/about") ||
           event.getMessage().startsWith("/plugins") ||
           event.getMessage().startsWith("/bukkit:plugins")){
            for(Player onlinePlayers : Bukkit.getOnlinePlayers()){
                if(!event.getPlayer().hasPermission("staffutilities.bypass.pl-hider")){
                    event.setCancelled(true);
                }else{
                    if(onlinePlayers.hasPermission("staffutilities.pl-hider.notify")){
                        if(!event.getPlayer().hasPermission("staffutilities.bypass.pl-hider")){
                            onlinePlayers.sendMessage(Message.PL_HIDER.toString()
                                    .replaceAll("%player%", event.getPlayer().getName()));
                        }
                    }
                }
            }
        }
    }

}
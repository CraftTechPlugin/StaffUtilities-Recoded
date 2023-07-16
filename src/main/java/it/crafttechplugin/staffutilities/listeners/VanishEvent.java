package it.crafttechplugin.staffutilities.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import java.util.ArrayList;

public class VanishEvent implements Listener {
    ArrayList<Player> invisible_list = new ArrayList<>();

    @EventHandler
    public void onItemPick(PlayerPickupItemEvent event){
        Player p = event.getPlayer();
        if(invisible_list.contains(p)){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        Player p = event.getPlayer();
        if (invisible_list.contains(p)) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        Player p = (Player) event.getEntity();
        if(invisible_list.contains(p)){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }
}

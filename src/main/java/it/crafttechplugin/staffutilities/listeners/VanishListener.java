package it.crafttechplugin.staffutilities.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import static it.crafttechplugin.staffutilities.Commands.Vanish.invisible_list;

public class VanishListener implements Listener {

    @EventHandler
    public void BlockBreak(BlockBreakEvent event){
        if(invisible_list.contains(event.getPlayer())){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }
    @EventHandler
    public void BlockPlace(BlockPlaceEvent event){
        if(invisible_list.contains(event.getPlayer())){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }
    @EventHandler
    public void damage(EntityDamageEvent event){
        if(invisible_list.contains(event.getEntity())){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent event){
        if(invisible_list.contains(event.getPlayer())){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        if(invisible_list.contains(event.getPlayer())){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        event.getPlayer().hidePlayer((Player) invisible_list);
    }
}

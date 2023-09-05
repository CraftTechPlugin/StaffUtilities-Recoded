package it.crafttechplugin.staffutilities.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import static it.crafttechplugin.staffutilities.Commands.Freeze.freeze_list;


public class FreezeListener implements Listener {

    @EventHandler
    public void BlockBreak(BlockBreakEvent event){
        if(freeze_list.contains(event.getPlayer())){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }
    @EventHandler
    public void BlockPlace(BlockPlaceEvent event){
        if(freeze_list.contains(event.getPlayer())){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }
    @EventHandler
    public void damage(EntityDamageEvent event){
        if(freeze_list.contains(event.getEntity())){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent event){
        if(freeze_list.contains(event.getPlayer())){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        if(freeze_list.contains(event.getPlayer())){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        if(freeze_list.contains(event.getPlayer())){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }
}

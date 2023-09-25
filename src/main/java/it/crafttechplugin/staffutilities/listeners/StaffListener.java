package it.crafttechplugin.staffutilities.listeners;

import it.crafttechplugin.staffutilities.Utils.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class StaffListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent e){
        if(e.getPlayer().getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Color.getColor("&bINVSEE"))){
            Player p = e.getPlayer();
            Player target = (Player) e.getRightClicked();
            p.openInventory(target.getInventory());
        }
    }
}

package it.crafttechplugin.staffutilities.listeners;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Color;
import me.frep.vulcan.api.VulcanAPI;
import org.apache.commons.lang.math.RandomUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static it.crafttechplugin.staffutilities.Commands.StaffMode.staffmode_list;

public class StaffListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent e){
        if(e.getPlayer().getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Color.getColor("&b&lINVSEE"))){
            Player p = e.getPlayer();
            Player target = (Player) e.getRightClicked();
            p.openInventory(target.getInventory());
        }
    }

    @EventHandler
    public void onInteract2(PlayerInteractEvent e){
        if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Color.getColor("&e&lRANDOM TP"))) {
            List<Player> players = new ArrayList<>();
            Player player = null;
            for (Player online : Bukkit.getOnlinePlayers()) {
                if (Bukkit.getOnlinePlayers().size() > players.size()) {
                    if (players.contains(online)) return;

                    players.add(online);

                    int randomPlayer = new Random().nextInt(players.size());

                    player = players.get(randomPlayer);
                }
            }

            assert player != null;
            Location loc = player.getLocation();

            e.getPlayer().teleport(loc);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        Player p = (Player) e.getDamager();
        if(staffmode_list.contains(p)){
            if(!p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Color.getColor("&c&lTEST KB"))){
                e.setCancelled(true);
            }
        }
    }
}

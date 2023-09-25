package it.crafttechplugin.staffutilities.listeners;

import it.crafttechplugin.staffutilities.Utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static it.crafttechplugin.staffutilities.Commands.StaffMode.staffmode_list;
import static it.crafttechplugin.staffutilities.Commands.Vanish.invisible_list;

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
        }else if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Color.getColor("&a&lVANISH ON"))){
            ItemStack vanish = new ItemStack(DyeColor.RED.getData());
            ItemMeta vanishmeta = vanish.getItemMeta();
            vanishmeta.setDisplayName(Color.getColor("&c&lVANISH OFF"));
            ArrayList<String> vanishlore = new ArrayList<>();
            vanishlore.add(Color.getColor("&bRight-click to"));
            vanishlore.add(Color.getColor("&bEnable the vanish"));
            vanishmeta.setLore(vanishlore);
            vanish.setItemMeta(vanishmeta);
            e.getPlayer().getInventory().setItem(8, vanish);
            invisible_list.remove(e.getPlayer());
        }else if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Color.getColor("&c&lVANISH OFF"))){
            ItemStack vanish = new ItemStack(DyeColor.GRAY.getData());
            ItemMeta vanishmeta = vanish.getItemMeta();
            vanishmeta.setDisplayName(Color.getColor("&a&lVANISH ON"));
            ArrayList<String> vanishlore = new ArrayList<>();
            vanishlore.add(Color.getColor("&bRight-click to"));
            vanishlore.add(Color.getColor("&bDisable the vanish"));
            vanishmeta.setLore(vanishlore);
            vanish.setItemMeta(vanishmeta);
            invisible_list.add(e.getPlayer());
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

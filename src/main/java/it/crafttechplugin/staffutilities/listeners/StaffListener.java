package it.crafttechplugin.staffutilities.listeners;

import it.crafttechplugin.staffutilities.Utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static it.crafttechplugin.staffutilities.Commands.StaffMode.staffmode_list;
import static it.crafttechplugin.staffutilities.customApi.inventories.inventoryApi.setPlayerInventoryItem;

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
        Player p = e.getPlayer();
        if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Color.getColor("&e&lRANDOM TP"))) {
            Bukkit.dispatchCommand((Player)p, "randomplayertp");

        }else if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Color.getColor("&a&lVANISH ON"))){
            ItemStack vanish = new ItemStack(DyeColor.RED.getData());
            ItemMeta vanishmeta = vanish.getItemMeta();
            vanishmeta.setDisplayName(Color.getColor("&c&lVANISH OFF"));
            ArrayList<String> vanishlore = new ArrayList<>();
            vanishlore.add(Color.getColor("&bRight-click to"));
            vanishlore.add(Color.getColor("&bEnable the vanish"));
            vanishmeta.setLore(vanishlore);
            vanish.setItemMeta(vanishmeta);
            setPlayerInventoryItem(p, 8, vanish);
            for(Player onlinePlayers : Bukkit.getOnlinePlayers()){
                onlinePlayers.showPlayer(p);
            }

        }else if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Color.getColor("&c&lVANISH OFF"))){
            ItemStack vanish = new ItemStack(DyeColor.GRAY.getData());
            ItemMeta vanishmeta = vanish.getItemMeta();
            vanishmeta.setDisplayName(Color.getColor("&a&lVANISH ON"));
            ArrayList<String> vanishlore = new ArrayList<>();
            vanishlore.add(Color.getColor("&bRight-click to"));
            vanishlore.add(Color.getColor("&bDisable the vanish"));
            vanishmeta.setLore(vanishlore);
            vanish.setItemMeta(vanishmeta);
            setPlayerInventoryItem(p, 8, vanish);
            for(Player people : Bukkit.getOnlinePlayers()){
                if(!people.hasPermission("staffutilities.vanish.see")){
                    people.hidePlayer(p);
                }
            }

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

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        if(staffmode_list.contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if(staffmode_list.contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
}

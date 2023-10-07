package it.crafttechplugin.staffutilities.listeners;

import it.crafttechplugin.staffutilities.Utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static it.crafttechplugin.staffutilities.Commands.StaffMode.staffmode_list;
import static it.crafttechplugin.staffutilities.Commands.Vanish.invisible_list;
import static it.crafttechplugin.staffutilities.customApi.randomTpApi.randomtp;

public class StaffListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent e){
        if(e.getPlayer().getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Color.getColor("&b&lINVSEE"))){
            Player p = e.getPlayer();
            Player target = (Player) e.getRightClicked();
            Inventory targetInventory = target.getInventory();
            p.openInventory(targetInventory);
        }
    }

    @EventHandler
    public void onInteract2(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(staffmode_list.contains(p)){
            ItemStack bussola = new ItemStack(Material.COMPASS);
            ItemStack vanishon = new ItemStack(DyeColor.GRAY.getData());
            ItemStack vanishoff = new ItemStack(DyeColor.RED.getData());
            if(e.getItem() == bussola){
                randomtp(p);
            }else if(e.getItem() == vanishon){
                ItemStack vanish = new ItemStack(DyeColor.RED.getData());
                ItemMeta vanishmeta = vanish.getItemMeta();
                vanishmeta.setDisplayName(Color.getColor("&c&lVANISH OFF"));
                ArrayList<String> vanishlore = new ArrayList<>();
                vanishlore.add(Color.getColor("&bRight-click to"));
                vanishlore.add(Color.getColor("&bEnable the vanish"));
                vanishmeta.setLore(vanishlore);
                vanish.setItemMeta(vanishmeta);
                p.getInventory().setItem(8, vanish);
                invisible_list.remove(p);
                for(Player people : Bukkit.getOnlinePlayers()){
                    people.showPlayer(p);
                }

            }else if(e.getItem() == vanishoff){
                ItemStack vanish = new ItemStack(DyeColor.GRAY.getData());
                ItemMeta vanishmeta = vanish.getItemMeta();
                vanishmeta.setDisplayName(Color.getColor("&a&lVANISH ON"));
                ArrayList<String> vanishlore = new ArrayList<>();
                vanishlore.add(Color.getColor("&bRight-click to"));
                vanishlore.add(Color.getColor("&bDisable the vanish"));
                vanishmeta.setLore(vanishlore);
                vanish.setItemMeta(vanishmeta);
                p.getInventory().setItem(8, vanish);
                invisible_list.add(p);
                for(Player people : Bukkit.getOnlinePlayers()){
                    if(!people.hasPermission("staffutilities.vanish.see")){
                        people.hidePlayer(p);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        Player p = (Player) e.getDamager();
        if(staffmode_list.contains(p)){
            e.setCancelled(true);
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

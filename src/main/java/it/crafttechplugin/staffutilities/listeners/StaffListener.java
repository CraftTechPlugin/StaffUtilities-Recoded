package it.crafttechplugin.staffutilities.listeners;

import it.crafttechplugin.staffutilities.Utils.Color;
import it.crafttechplugin.staffutilities.Utils.Message;
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
import java.util.List;
import java.util.Random;

import static it.crafttechplugin.staffutilities.Commands.StaffMode.staffmode_list;
import static it.crafttechplugin.staffutilities.customApi.inventoryApi.getDisplayName;
import static it.crafttechplugin.staffutilities.customApi.inventoryApi.setPlayerInventoryItem;
import static it.crafttechplugin.staffutilities.customApi.vanishApi.disableVanish;
import static it.crafttechplugin.staffutilities.customApi.vanishApi.enableVanish;

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
        String randomTP = "&e&lRANDOM TP";
        String vanishon = "&a&lVANISH ON";
        String vanishoff = "&c&lVANISH OFF";
        if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(randomTP)){
            Random random = new Random();
            List<Player> onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
            onlinePlayers.remove(p);
            if(onlinePlayers.isEmpty()){
                p.sendMessage(Message.PREFIX.toString() + Message.OFFLINE_PLAYER);
            }
            int randomIndex = random.nextInt(onlinePlayers.size());
            Player target = onlinePlayers.get(randomIndex);
            p.teleport(target.getLocation());

        }else if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(vanishon)){
            ItemStack vanish = new ItemStack(DyeColor.RED.getData());
            ItemMeta vanishmeta = vanish.getItemMeta();
            vanishmeta.setDisplayName(Color.getColor("&c&lVANISH OFF"));
            ArrayList<String> vanishlore = new ArrayList<>();
            vanishlore.add(Color.getColor("&bRight-click to"));
            vanishlore.add(Color.getColor("&bEnable the vanish"));
            vanishmeta.setLore(vanishlore);
            vanish.setItemMeta(vanishmeta);
            setPlayerInventoryItem(p, 8, vanish);
            disableVanish(p);

        }else if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(vanishoff)){
            ItemStack vanish = new ItemStack(DyeColor.GRAY.getData());
            ItemMeta vanishmeta = vanish.getItemMeta();
            vanishmeta.setDisplayName(Color.getColor("&a&lVANISH ON"));
            ArrayList<String> vanishlore = new ArrayList<>();
            vanishlore.add(Color.getColor("&bRight-click to"));
            vanishlore.add(Color.getColor("&bDisable the vanish"));
            vanishmeta.setLore(vanishlore);
            vanish.setItemMeta(vanishmeta);
            setPlayerInventoryItem(p, 8, vanish);
            enableVanish(p);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        String kbtest = "&c&lTEST KB";
        Player p = (Player) e.getDamager();
        if(staffmode_list.contains(p)){
            if(!getDisplayName(kbtest)){
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

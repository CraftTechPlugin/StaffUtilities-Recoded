package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static it.crafttechplugin.staffutilities.Commands.Vanish.invisible_list;
import static it.crafttechplugin.staffutilities.Main.msg;

public class StaffMode implements CommandExecutor {
    public static ArrayList<Player> staffmode_list = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(p.hasPermission("staffutilities.staffmode")){
                if(!staffmode_list.contains(p)){
                    ItemStack randomtp = new ItemStack(Material.COMPASS);
                    ItemMeta randomtpmeta = randomtp.getItemMeta();
                    randomtpmeta.setDisplayName(Color.getColor("&bRANDOM TELEPORT"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(Color.getColor("&bRight-click to"));
                    lore.add(Color.getColor("&bTeleport from a"));
                    lore.add(Color.getColor("&bRandom player."));
                    randomtpmeta.setLore(lore);
                    randomtp.setItemMeta(randomtpmeta);

                    ItemStack invsee = new ItemStack(Material.BOOK);
                    ItemMeta invseemeta = invsee.getItemMeta();
                    invseemeta.setDisplayName(Color.getColor("&bINVSEE"));
                    ArrayList<String> loreinvsee = new ArrayList<>();
                    loreinvsee.add(Color.getColor("&bRight-click to"));
                    loreinvsee.add(Color.getColor("&bOpen a player's"));
                    loreinvsee.add(Color.getColor("&bInventory."));
                    randomtpmeta.setLore(loreinvsee);
                    invsee.setItemMeta(invseemeta);
                    if(invisible_list.contains(p)){
                        invisible_list.remove(p);
                        for(Player people : Bukkit.getOnlinePlayers()){
                            people.showPlayer(p);
                        }
                    }else{
                        invisible_list.add(p);
                        for(Player people : Bukkit.getOnlinePlayers()){
                            people.hidePlayer(p);
                        }
                    }
                    p.getInventory().setItem(0, randomtp);
                    p.getInventory().setItem(8, invsee);
                    p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.StaffModeon")));
                }
            }else{
                p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
            }
        }else{
            commandSender.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
        }
        return false;
    }
}

package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Utils.Color;
import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class StaffMode implements CommandExecutor {
    public static ArrayList<Player> staffmode_list = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("staffutilities.staffmode")) {
                if (!staffmode_list.contains(p)) {
                    p.setAllowFlight(true);
                    ItemStack randomtp = new ItemStack(Material.COMPASS);
                    ItemMeta randomtpmeta = randomtp.getItemMeta();
                    randomtpmeta.setDisplayName(Color.getColor("&e&lRANDOM TELEPORT"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(Color.getColor("&bRight-click to"));
                    lore.add(Color.getColor("&bTeleport from a"));
                    lore.add(Color.getColor("&bRandom player."));
                    randomtpmeta.setLore(lore);
                    randomtp.setItemMeta(randomtpmeta);
                    ItemStack invsee = new ItemStack(Material.BOOK);
                    ItemMeta invseemeta = invsee.getItemMeta();
                    invseemeta.setDisplayName(Color.getColor("&b&lINVSEE"));
                    ArrayList<String> loreinvsee = new ArrayList<>();
                    loreinvsee.add(Color.getColor("&bRight-click to"));
                    loreinvsee.add(Color.getColor("&bOpen a player's"));
                    loreinvsee.add(Color.getColor("&bInventory."));
                    randomtpmeta.setLore(loreinvsee);
                    invsee.setItemMeta(invseemeta);
                    if (!Vanish.invisible_list.contains(p)) {
                        Vanish.invisible_list.add(p);
                        ItemStack vanish = new ItemStack(DyeColor.RED.getData());
                        ItemMeta vanishmeta = vanish.getItemMeta();
                        vanishmeta.setDisplayName(Color.getColor("&c&lVANISH OFF"));
                        ArrayList<String> vanishlore = new ArrayList<>();
                        vanishlore.add(Color.getColor("&bRight-click to"));
                        vanishlore.add(Color.getColor("&bEnable the vanish"));
                        vanishmeta.setLore(vanishlore);
                        vanish.setItemMeta(vanishmeta);
                        p.getInventory().setItem(8, vanish);
                        for (Player people : Bukkit.getOnlinePlayers())
                            people.showPlayer(p);
                    }
                    ItemStack kbtest = new ItemStack(Material.BLAZE_ROD);
                    ItemMeta kbtestmeta = kbtest.getItemMeta();
                    kbtestmeta.setDisplayName(Color.getColor("&c&lTEST KB"));
                    ArrayList<String> kbtestlore = new ArrayList<>();
                    kbtestlore.add(Color.getColor("&bRight-click to"));
                    kbtestlore.add(Color.getColor("&bMake a kb test"));
                    kbtestlore.add(Color.getColor("&bFor damaged player"));
                    kbtestmeta.setLore(kbtestlore);
                    kbtest.setItemMeta(kbtestmeta);
                    p.getInventory().setItem(0, randomtp);
                    p.getInventory().setItem(1, invsee);
                    p.getInventory().setItem(7, kbtest);
                    p.sendMessage(Message.STAFF_MODE_ON.toString());
                } else {
                    p.sendMessage(Message.STAFF_MODE_OFF.toString());
                    staffmode_list.remove(p);
                    p.getInventory().clear();
                }
            } else {
                p.sendMessage(Message.NO_PERMS.toString());
            }
        } else {
            sender.sendMessage(Message.NO_PERMS.toString());
        }
        return false;
    }
}
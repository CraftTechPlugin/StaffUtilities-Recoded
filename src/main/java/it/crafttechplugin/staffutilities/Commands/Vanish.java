package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class Vanish implements CommandExecutor, Listener {


    public static ArrayList<Player> invisible_list = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration msg = Main.msg;
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("staffutilities.vanish.use")) {
                if (strings.length == 0) {
                    if (invisible_list.contains(p)) {
                        for (Player people : Bukkit.getOnlinePlayers()) {
                            people.showPlayer(p);
                        }
                        invisible_list.remove(p);
                        p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.VanishOff")));
                    } else if (!invisible_list.contains(p)) {
                        for (Player people : Bukkit.getOnlinePlayers()) {
                            if (!people.hasPermission("staffutilities.vanish.see")) {
                                people.hidePlayer(p);
                            }
                        }
                        invisible_list.add(p);
                        p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.VanishOn")));
                    }
                } else {
                    Player target = Bukkit.getPlayer(strings[0]);
                    if (target == null) {
                        p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.OfflinePlayer")));
                    } else {
                        if (invisible_list.contains(target)) {
                            for (Player people : Bukkit.getOnlinePlayers()) {
                                people.showPlayer(target);
                            }
                            invisible_list.remove(target);
                            target.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.VanishOff")));
                        } else if (!invisible_list.contains(target)) {
                            for (Player people : Bukkit.getOnlinePlayers()) {
                                if (!people.hasPermission("staffutilities.vanish.see")) {
                                    people.hidePlayer(target);
                                }
                            }
                            invisible_list.add(target);
                            target.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.VanishOn")));
                        }
                    }
                }
            } else {
                commandSender.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
            }
        } else {
            commandSender.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
        }
        return true;
    }
}

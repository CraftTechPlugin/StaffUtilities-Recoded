package it.crafttechplugin.staffutilities.Commands;

import java.util.ArrayList;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {
    YamlConfiguration msg = (YamlConfiguration) Main.data;
    ArrayList<Player> invisible_list = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("staffutilities.vanish")) {
                if(strings.length == 0) {
                    if (invisible_list.contains(p)) {
                        for (Player people : Bukkit.getOnlinePlayers()) {
                            people.showPlayer(p);
                        }
                        invisible_list.remove(p);
                        p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.VanishOff")));
                    } else if (!invisible_list.contains(p)) {
                        for (Player people : Bukkit.getOnlinePlayers()) {
                            people.hidePlayer(p);
                        }
                        invisible_list.add(p);
                        p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.VanishOn")));
                    }
                }else{
                    Player target = (Player) Bukkit.getPlayer(strings[0]);
                    if(target == null) {
                        p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.offlinePlayer")));
                    }else {
                        if (invisible_list.contains(target)) {
                            for (Player people : Bukkit.getOnlinePlayers()) {
                                people.showPlayer(target);
                            }
                            invisible_list.remove(target);
                            target.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.VanishOff")));
                        } else if (!invisible_list.contains(target)) {
                            for (Player people : Bukkit.getOnlinePlayers()) {
                                people.hidePlayer(target);
                            }
                            invisible_list.add(target);
                            target.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.VanishOn")));
                        }
                    }
                }
            }else{
                commandSender.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
            }
        }else{
            commandSender.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
        }
        return true;
    }
}

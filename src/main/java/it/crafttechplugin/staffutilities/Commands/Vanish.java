package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class Vanish implements CommandExecutor, Listener {


    public static ArrayList<Player> invisible_list = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("staffutilities.vanish.use")) {
                if (strings.length == 0) {
                    if (invisible_list.contains(p)) {
                        invisible_list.remove(p);
                        p.sendMessage(Message.VANISH_OFF.toString());
                        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                            onlinePlayers.showPlayer(p);
                        }
                    } else {
                        invisible_list.add(p);
                        p.sendMessage(Message.VANISH_ON.toString());
                        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                            if (!onlinePlayers.hasPermission("staffutilities.vanish.see")) {
                                onlinePlayers.hidePlayer(p);
                            }
                        }
                    }
                } else {
                    Player target = Bukkit.getPlayer(strings[0]);
                    if (target == null) {
                        p.sendMessage(Message.PREFIX.toString() + Message.OFFLINE_PLAYER);
                    } else {
                        if (invisible_list.contains(p)) {
                            invisible_list.remove(p);
                            p.sendMessage(Message.VANISH_OFF.toString());
                            for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                                onlinePlayers.showPlayer(p);
                            }
                        } else {
                            invisible_list.add(p);
                            p.sendMessage(Message.VANISH_ON.toString());
                            for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                                if (!onlinePlayers.hasPermission("staffutilities.vanish.see")) {
                                    onlinePlayers.hidePlayer(p);
                                }
                            }
                        }
                    }
                }
            }else{
                p.sendMessage(Message.NO_PERMS.toString());
            }
        } else {
            sender.sendMessage(Message.NO_PERMS.toString());
        }
        return true;
    }
}

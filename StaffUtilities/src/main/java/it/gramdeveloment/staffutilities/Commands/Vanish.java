package it.gramdeveloment.staffutilities.Commands;

import java.util.ArrayList;

import it.gramdeveloment.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static it.gramdeveloment.staffutilities.Main.plugin;

public class Vanish implements CommandExecutor {
    ArrayList<Player> invisible_list = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("staffutilities.vanish") || p.hasPermission("staffutilities.*")) {
                if (invisible_list.contains(p)) {
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        people.showPlayer(p);
                    }
                    invisible_list.remove(p);
                    p.sendMessage(ColorTranslateUtil.getColor(plugin.getConfig().getString("Messages.Prefix")+plugin.getConfig().getString("Messages.VanishOff")));
                }else if(!invisible_list.contains(p)) {
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        people.hidePlayer(p);
                    }
                    invisible_list.add(p);
                    p.sendMessage(ColorTranslateUtil.getColor(plugin.getConfig().getString("Messages.Prefix")+plugin.getConfig().getString("Messages.VanishOn")));
                }
            }else {
                p.sendMessage(ColorTranslateUtil.getColor(plugin.getConfig().getString("Messages.Prefix")+plugin.getConfig().getString("Messages.UnknowCommand")));
            }
        }return true;
    }
}

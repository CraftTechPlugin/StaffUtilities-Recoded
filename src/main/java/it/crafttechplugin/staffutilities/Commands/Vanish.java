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
                if (invisible_list.contains(p)) {
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        people.showPlayer(p);
                    }
                    invisible_list.remove(p);
                    p.sendMessage(ColorTranslateUtil.getColor(Main.plugin.getConfig().getString("Messages.Prefix")+ Main.plugin.getConfig().getString("Messages.VanishOff")));
                }else if(!invisible_list.contains(p)) {
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        people.hidePlayer(p);
                    }
                    invisible_list.add(p);
                    p.sendMessage(ColorTranslateUtil.getColor(Main.plugin.getConfig().getString("Messages.Prefix")+ Main.plugin.getConfig().getString("Messages.VanishOn")));
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

package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Utils.Colors;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static it.crafttechplugin.staffutilities.Main.msg;

public class SpyCommand implements CommandExecutor {
    public static ArrayList<Player> spylogs = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if(p.hasPermission("staffutilities.spy")){
                if(spylogs.contains(p)){
                    spylogs.remove(p);
                    p.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.SpyLogsoff")));
                }else {
                    p.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.SpyLogson")));
                    spylogs.add(p);
                }
            }else{
                p.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
            }
        } else {
            commandSender.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
        }
        return false;
    }
}
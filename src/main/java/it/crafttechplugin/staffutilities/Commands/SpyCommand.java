package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class SpyCommand implements CommandExecutor {
    public static ArrayList<Player> spylogs = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("staffutilities.spy")){
                if(spylogs.contains(p)){
                    spylogs.remove(p);
                    p.sendMessage(Message.SPY_LOGS_OFF.toString());
                }else {
                    p.sendMessage(Message.SPY_LOGS_ON.toString());
                    spylogs.add(p);
                }
            }else{
                p.sendMessage(Message.NO_PERMS.toString());
            }
        } else {
            sender.sendMessage(Message.NO_PERMS.toString());
        }
        return false;
    }
}
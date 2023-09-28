package it.crafttechplugin.staffutilities.Commands.Teleport;


import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class randomPlayerTp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("staffutilities.randomplayertp")){
                Random random = new Random();
                List<Player> onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
                onlinePlayers.remove(p);
                if(onlinePlayers.isEmpty()){
                    p.sendMessage(Message.PREFIX.toString() + Message.OFFLINE_PLAYER);
                    return false;
                }
                int randomIndex = random.nextInt(onlinePlayers.size());
                Player target = onlinePlayers.get(randomIndex);
                p.teleport(target.getLocation());
            }else{
                p.sendMessage(Message.PREFIX.toString() + Message.NO_PERMS);
            }
        }else{
            sender.sendMessage(Message.PREFIX.toString() + Message.NO_PERMS);
        }
        return false;
    }
}

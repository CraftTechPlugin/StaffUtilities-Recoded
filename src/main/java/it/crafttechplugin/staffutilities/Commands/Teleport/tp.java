package it.crafttechplugin.staffutilities.Commands.Teleport;

import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("staffutilities.tp")){
                if(strings.length == 0){
                    player.sendMessage(Message.NO_ARGS.toString());
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    if(target == null){
                        player.sendMessage(Message.OFFLINE_PLAYER.toString());
                    }else{
                        player.teleport(target.getLocation());
                        player.sendMessage(Message.TP.toString().replaceAll("%player", target.getName()));
                    }
                }
            }else {
                player.sendMessage(Message.NO_PERMS.toString());
            }
        }else{
            sender.sendMessage(Message.NO_PERMS.toString());
        }
        return false;
    }
}

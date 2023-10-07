package it.crafttechplugin.staffutilities.Commands.Teleport;

import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpHere implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("staffutilities.tphere")){
                if(strings.length == 0){
                    player.sendMessage(Message.NO_ARGS.toString());
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    if(target == null){
                        player.sendMessage(Message.OFFLINE_PLAYER.toString());
                    }else{
                        target.teleport(player.getLocation());
                        player.sendMessage(Message.TP_HERE.toString());
                    }
                }
            }else{
                player.sendMessage(Message.TP_HERE.toString());
            }
        }else{
            sender.sendMessage(Message.NO_PERMS.toString());
        }
        return false;
    }
}

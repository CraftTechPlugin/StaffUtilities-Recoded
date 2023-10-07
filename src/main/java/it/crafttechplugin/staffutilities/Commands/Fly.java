package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("staffutilities.fly")) {
                if(player.getAllowFlight()){
                    player.setAllowFlight(false);
                    player.sendMessage(Message.FLY_OFF.toString());
                }else{
                    player.setAllowFlight(true);
                    player.sendMessage(Message.FLY_ON.toString());
                }
            }else{
                player.sendMessage(Message.NO_PERMS.toString());
            }
        }else{
            sender.sendMessage(Message.NO_PERMS.toString());
        }
        return false;
    }
}

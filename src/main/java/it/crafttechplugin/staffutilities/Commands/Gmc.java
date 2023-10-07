package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gmc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("staffutilities.gmc")){
                if(player.getGameMode().equals(GameMode.CREATIVE)){
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(Message.GMC_OFF.toString());
                }else{
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(Message.GMC_ON.toString());
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

package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Freeze implements CommandExecutor {

    public static ArrayList<Player> freeze_list = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("staffutilities.freeze")){
                if(strings.length == 0){
                    player.sendMessage(Message.NO_ARGS.toString());
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    if(target == null){
                        player.sendMessage(Message.OFFLINE_PLAYER.toString());
                    }else{
                        if(freeze_list.contains(target)){
                            freeze_list.remove(target);
                            player.sendMessage(Message.FREEZE_OFF.toString().replaceAll("%player%", target.getName()));
                        }else{
                            freeze_list.add(target);
                            player.sendMessage(Message.FREEZE_ON.toString().replaceAll("%player%", target.getName()));
                        }
                    }
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

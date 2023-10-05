package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Color;
import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class Freeze implements CommandExecutor, Listener {
    public static ArrayList<Player> freeze_list = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("staffutlities.freeze")){
                if(strings[0].length() == 0){
                    p.sendMessage(Message.NO_ARGS.toString());
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    if (target == null){
                        p.sendMessage(Message.OFFLINE_PLAYER.toString());
                    }else{
                        if(freeze_list.contains(target)){
                            freeze_list.remove(target);
                            p.sendMessage(Message.FREEZE_OFF.toString().replaceAll("%player%", target.getName()));
                        }else{
                            freeze_list.add(target);
                            p.sendMessage(Message.FREEZE_OFF.toString().replaceAll("%player%", target.getName()));
                        }
                    }
                }
            }else {
                p.sendMessage(Message.NO_PERMS.toString());
            }
        }else{
            sender.sendMessage(Message.NO_PERMS.toString());
        }
        return false;
    }
}

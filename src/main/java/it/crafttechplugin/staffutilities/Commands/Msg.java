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

public class Msg implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            String sm = "";
            for(int i = 1; i < strings.length;i++) {
                String arg = (strings[i] + " ");
                sm = (sm + arg);
            }
            Player p = (Player) sender;
            if(strings[0].length() == 0){
                p.sendMessage(Message.NO_ARGS.toString());
            }else{
                Player target = Bukkit.getPlayer(strings[0]);
                if(target == null){
                    p.sendMessage(Message.OFFLINE_PLAYER.toString());
                }else{
                    if(strings[1].length() == 0){
                        p.sendMessage(Message.NO_ARGS.toString());
                    }else{
                        if(strings[1] == s) {
                            target.sendMessage(Message.RECEIVED_MSG + sm.replaceAll("%sender%", p.getName()));
                            p.sendMessage(Message.RECEIVED_MSG + sm.replaceAll("%receiver%", target.getName()));
                        }
                    }
                }
            }
        }else{
            sender.sendMessage(Message.NO_PERMS.toString());
        }
        return false;
    }
}

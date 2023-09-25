package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Msg implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration msg = Main.msg;
        if(commandSender instanceof Player){
            String sm = "";
            for(int i = 1; i < strings.length;i++) {
                String arg = (strings[i] + " ");
                sm = (sm + arg);
            }
            Player p = (Player) commandSender;
            if(strings[0].length() == 0){
                p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noArgs")));
            }else{
                Player target = Bukkit.getPlayer(strings[0]);
                if(target == null){
                    p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.OfflinePlayer")));
                }else{
                    if(strings[1].length() == 0){
                        p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noArgs")));
                    }else{
                        if(strings[1] == s) {
                            target.sendMessage(Color.getColor(msg.getString("Messages.received-msg") + sm).replaceAll("%sender%", p.getName()));
                            p.sendMessage(Color.getColor(msg.getString("Messages.sended-msg") + sm).replaceAll("%receiver%", target.getName()));
                        }
                    }
                }
            }
        }else{
            commandSender.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
        }
        return false;
    }
}

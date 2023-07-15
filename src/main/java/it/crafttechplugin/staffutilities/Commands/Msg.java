package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
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
            Player p = (Player) commandSender;
            if(strings[0].length() == 0){
                p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noArgs")));
            }else{
                Player target = Bukkit.getPlayer(strings[0]);
                if(target == null){
                    p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.OfflinePlayer")));
                }else{
                    if(strings[1].length() == 0){
                        p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noArgs")));
                    }else{
                        String mess = strings[1];
                        target.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.received-msg") + mess) .replaceAll("%sender%", p.getName()));
                        p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.sended-msg") + mess) .replaceAll("%receiver%", target.getName()));
                    }
                }
            }
        }else{
            commandSender.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
        }
        return false;
    }
}

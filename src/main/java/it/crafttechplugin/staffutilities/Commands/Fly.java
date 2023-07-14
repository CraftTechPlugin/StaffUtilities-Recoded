package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Fly implements CommandExecutor {
    private File msgf;
    private FileConfiguration msg;


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("staffutilities.fly")) {
                if(strings.length == 0) {
                    if (p.getAllowFlight()) {
                        p.setAllowFlight(false);
                        p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.FlyOff")));
                    } else {
                        p.setAllowFlight(true);
                        p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.FlyOn")));
                    }
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    if(target == null){
                        p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.OfflinePlayer")));
                    }else{
                        if (target.getAllowFlight()) {
                            target.setAllowFlight(false);
                            target.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.FlyOff")));
                        } else {
                            target.setAllowFlight(true);
                            target.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.FlyOn")));
                        }
                    }
                }
            }else{
                commandSender.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
            }
        }else{
            commandSender.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
        }
        return false;
    }
}
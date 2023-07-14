package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    YamlConfiguration msg = (YamlConfiguration) Main.data;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("staffutilities.fly")) {
                if(strings.length == 0) {
                    if (p.getAllowFlight()) {
                        p.setAllowFlight(false);
                        p.sendMessage(ColorTranslateUtil.getColor(Main.plugin.getConfig().getString("Messages.Prefix") + Main.plugin.getConfig().getString("Messages.FlyOff")));
                    } else {
                        p.setAllowFlight(true);
                        p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + Main.plugin.getConfig().getString("Messages.FlyOn")));
                    }
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    if(target == null){
                        p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.offlinePlayer")));
                    }else{
                        if (p.getAllowFlight()) {
                            p.setAllowFlight(false);
                            p.sendMessage(ColorTranslateUtil.getColor(Main.plugin.getConfig().getString("Messages.Prefix") + Main.plugin.getConfig().getString("Messages.FlyOff")));
                        } else {
                            p.setAllowFlight(true);
                            p.send
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
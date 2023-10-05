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

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("staffutilities.fly")) {
                if(strings.length == 0) {
                    if (p.getAllowFlight()) {
                        p.setAllowFlight(false);
                        p.sendMessage(Message.FLY_OFF.toString());
                    } else {
                        p.setAllowFlight(true);
                        p.sendMessage(Message.FLY_ON.toString());
                    }
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    if(target == null){
                        p.sendMessage(Message.NO_ARGS.toString());
                    }else{
                        if (target.getAllowFlight()) {
                            target.setAllowFlight(false);
                            target.sendMessage(Message.FLY_OFF.toString());
                        } else {
                            target.setAllowFlight(true);
                            target.sendMessage(Message.FLY_ON.toString());
                        }
                    }
                }
            }else{
                p.sendMessage(Message.NO_PERMS.toString());
            }
        }else{
            sender.sendMessage(Message.NO_PERMS.toString());
        }
        return false;
    }
}
package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Color;
import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Gmc implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("staffutilities.gmc")) {
                if (strings.length == 0){
                    if (p.getGameMode() == GameMode.CREATIVE) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(Message.GMC_OFF.toString());
                    }else if (p.getGameMode() == GameMode.SURVIVAL) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Message.GMC_ON.toString());
                    }
                }else {
                    Player t = Bukkit.getPlayer(strings[0]);
                    if (t==null){
                        p.sendMessage(Message.OFFLINE_PLAYER.toString());
                    }else{
                        if (t.getGameMode() == GameMode.CREATIVE) {
                            t.setGameMode(GameMode.SURVIVAL);
                            t.sendMessage(Message.GMC_OFF.toString());
                        }
                        else if (t.getGameMode() == GameMode.SURVIVAL) {
                            t.setGameMode(GameMode.CREATIVE);
                            t.sendMessage(Message.GMC_ON.toString());
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

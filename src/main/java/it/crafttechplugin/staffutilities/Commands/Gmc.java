package it.crafttechplugin.staffutilities.Commands;

import com.sun.org.apache.xpath.internal.operations.Variable;
import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Gmc implements CommandExecutor {
    private File msgf;
    private FileConfiguration msg;


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("staffutilities.gmc")) {
                if (strings.length == 0){
                    if (p.getGameMode() == GameMode.CREATIVE) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix")+ msg.getString("Messages.GmcOff")));
                    }
                    else if (p.getGameMode() == GameMode.SURVIVAL) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix")+ msg.getString("Messages.GmcOn")));
                    }

                }else if (strings.length > 3){
                    Player t = Bukkit.getPlayer(strings[0]);
                    if (t==null){
                        p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("OfflinePlayer")));
                    }else{
                        if (t.getGameMode() == GameMode.CREATIVE) {
                            t.setGameMode(GameMode.SURVIVAL);
                            t.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix")+ msg.getString("Messages.GmcOff")));
                        }
                        else if (t.getGameMode() == GameMode.SURVIVAL) {
                            t.setGameMode(GameMode.CREATIVE);
                            t.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix")+ msg.getString("Messages.GmcOn")));
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

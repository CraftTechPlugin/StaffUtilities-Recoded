package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Color;
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
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration msg = Main.msg;
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(p.hasPermission("staffutlities.freeze")){
                if(strings[0].length() == 0){
                    p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noArgs")));
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    if (target == null){
                        p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.OfflinePlayer")));
                    }else{
                        if(freeze_list.contains(target)){
                            freeze_list.remove(target);
                            p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.FreezeOff").replaceAll("%player%", target.getName())));
                        }else{
                            freeze_list.add(target);
                            p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.FreezeOn").replaceAll("%player%", target.getName())));
                        }
                    }
                }
            }else {
                p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
            }
        }else{
            commandSender.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
        }
        return false;
    }
}

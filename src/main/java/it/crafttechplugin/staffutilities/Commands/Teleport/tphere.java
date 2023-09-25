package it.crafttechplugin.staffutilities.Commands.Teleport;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Color;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class tphere implements CommandExecutor {
    private File msgf;
    private FileConfiguration msg;


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(p.hasPermission("staffutilities.tphere")){
                if(strings.length == 0){
                    p.sendMessage(Color.getColor(Main.getInstance().getConfig().getString("Messages.Prefix") + Main.getInstance().getConfig().getString("Messages.noArguments")));
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    target.teleport(p);
                    String without = Color.getColor(msg.getString("Messages.Tp"))
                            .replaceAll("%player%", p.getName());
                    String with = PlaceholderAPI.setPlaceholders(p, without);
                    p.sendMessage(Color.getColor(msg.getString("Messages.Prefix")+with));
                }
            }else{
                commandSender.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
            }
        }else{
            commandSender.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
        }
        return false;
    }
}
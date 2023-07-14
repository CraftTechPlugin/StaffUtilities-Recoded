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

public class InvSee implements CommandExecutor {
    private File msgf;
    private FileConfiguration msg;


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(p.hasPermission("staffutilities.invsee")){
                if(strings.length == 0){
                    p.sendMessage(ColorTranslateUtil.getColor("Insert player"));
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    p.openInventory(target.getInventory());
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

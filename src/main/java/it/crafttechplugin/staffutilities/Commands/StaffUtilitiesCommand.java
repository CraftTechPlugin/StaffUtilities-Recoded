package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Colors;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class StaffUtilitiesCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration msg = Main.msg;
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            p.sendMessage(Colors.getColor("&b&lSTAFFUTILITIES by CraftTechPlugin"));
            if( p.hasPermission("staffutilities.help")){
                p.sendMessage("");
                p.sendMessage(Colors.getColor("&b&lCOMMANDS"));
                p.sendMessage(Colors.getColor("&b/fly &7(Toggle fly mode)"));
                p.sendMessage(Colors.getColor("&b/pl &7(Show the plugin list if you have the permission)"));
                p.sendMessage(Colors.getColor("&b/plugins &7(Show the plugin list if you have the permission)"));
                p.sendMessage(Colors.getColor("&b/staffutilities &7(Show this message)"));
                p.sendMessage(Colors.getColor("&b/startevent &7(Start the server opening event)"));
                p.sendMessage(Colors.getColor("&b/vanish &7(Toggle vanish)"));
                p.sendMessage(Colors.getColor("&b/gmc &7(Toggle creative gamemode)"));
                p.sendMessage(Colors.getColor("&b/tp &7(Teleports you from another player)"));;
                p.sendMessage(Colors.getColor("&b/tphere &7(Teleports a player to you)"));
                p.sendMessage(Colors.getColor("&b/creload &7(Reload config.yml)"));
            }
    }else{
        commandSender.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
    }
        return false;
    }
}

package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffUtilitiesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            p.sendMessage(ColorTranslateUtil.getColor("&c&lSTAFF&4&lUTILITIES &cby CraftTechPlugin"));
            if( p.hasPermission("staffutilities.help")){
                p.sendMessage("");
                p.sendMessage(ColorTranslateUtil.getColor("&b&lCOMMANDS"));
                p.sendMessage(ColorTranslateUtil.getColor("&b/credits &7(Show the credits of the plugin)"));
                p.sendMessage(ColorTranslateUtil.getColor("&b/fly &7(Toggle fly mode)"));
                p.sendMessage(ColorTranslateUtil.getColor("&b/pl &7(Show the plugin list if you have the permission)"));
                p.sendMessage(ColorTranslateUtil.getColor("&b/plugins &7(Show the plugin list if you have the permission)"));
                p.sendMessage(ColorTranslateUtil.getColor("&b/staffutilities &7(Show this message)"));
                p.sendMessage(ColorTranslateUtil.getColor("&b/startevent &7(Start the server opening event)"));
                p.sendMessage(ColorTranslateUtil.getColor("&b/vanish &7(Toggle vanish)"));
                p.sendMessage(ColorTranslateUtil.getColor("&b/gmc &7(Toggle creative gamemode)"));
                p.sendMessage(ColorTranslateUtil.getColor("&b/tp &7(Teleports you from another player)"));;
                p.sendMessage(ColorTranslateUtil.getColor("&b/tphere &7(Teleports a player to you)"));
            }
        }else {
            commandSender.sendMessage("Only players can execute this command");
        }
        return false;
    }
}

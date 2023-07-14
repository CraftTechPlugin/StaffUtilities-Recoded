package it.gramdeveloment.staffutilities.Commands;

import it.gramdeveloment.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffUtilitiesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            p.sendMessage(ColorTranslateUtil.getColor("&c&lSTAFF&4&lUTILITIES &cby ImReddo_ & ItzFrancy"));
            if(p.hasPermission("staffutilities.*") || p.hasPermission("staffutilities.help")){
                p.sendMessage("");
                p.sendMessage(ColorTranslateUtil.getColor("&4&lCOMMANDS"));
                p.sendMessage(ColorTranslateUtil.getColor("&c/credits &7(Show the credits of the plugin)"));
                p.sendMessage(ColorTranslateUtil.getColor("&c/fly &7(Toggle fly mode)"));
                p.sendMessage(ColorTranslateUtil.getColor("&c/pl &7(Show the plugin list if you have the permission)"));
                p.sendMessage(ColorTranslateUtil.getColor("&c/plugins &7(Show the plugin list if you have the permission)"));
                p.sendMessage(ColorTranslateUtil.getColor("&c/staffutilities &7(Show this message)"));
                p.sendMessage(ColorTranslateUtil.getColor("&c/startevent &7(Start the server opening event)"));
                p.sendMessage(ColorTranslateUtil.getColor("&c/vanish &7(Toggle vanish)"));
                p.sendMessage(ColorTranslateUtil.getColor("&c/gmc &7(Toggle creative gamemode)"));
                p.sendMessage(ColorTranslateUtil.getColor("&c/tp &7(Teleports you from another player)"));;
                p.sendMessage(ColorTranslateUtil.getColor("&c/tphere &7(Teleports a player to you)"));
                p.sendMessage("");
                p.sendMessage(ColorTranslateUtil.getColor("&4&lDISCORD SUPPORT &8» &c&nhttps://discord.gg/rEpd6P7J8X"));
            }
        }else {
            commandSender.sendMessage("Only players can execute this command");
        }
        return false;
    }
}

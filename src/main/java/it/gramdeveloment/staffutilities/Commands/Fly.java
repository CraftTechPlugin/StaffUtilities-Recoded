package it.gramdeveloment.staffutilities.Commands;

import it.gramdeveloment.staffutilities.Main;
import it.gramdeveloment.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("staffutilities.fly") || p.hasPermission("staffutilities.*")) {
                if(p.getAllowFlight()) {
                    p.setAllowFlight(false);
                    p.sendMessage(ColorTranslateUtil.getColor(Main.plugin.getConfig().getString("Messages.Prefix")+Main.plugin.getConfig().getString("Messages.FlyOff")));
                } else {
                    p.setAllowFlight(true);
                    p.sendMessage(ColorTranslateUtil.getColor(Main.plugin.getConfig().getString("Messages.Prefix")+Main.plugin.getConfig().getString("Messages.FlyOn")));
                }
            } else {
                p.sendMessage(ColorTranslateUtil.getColor(Main.plugin.getConfig().getString("Messages.Prefix")+Main.plugin.getConfig().getString("Messages.UnknowCommand")));
            }
        }
        return false;
    }
}
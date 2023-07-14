package it.gramdeveloment.staffutilities.Commands;

import it.gramdeveloment.staffutilities.Main;
import org.bukkit.Bukkit;
import it.gramdeveloment.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class StartEvent implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("staffutilities.startevent") || p.hasPermission("staffutilities.*")) {
                p.getWorld().spawnEntity(p.getLocation(), EntityType.LIGHTNING);
                p.getWorld().spawnEntity(p.getLocation(), EntityType.LIGHTNING);
                p.getWorld().spawnEntity(p.getLocation(), EntityType.GIANT);
                Bukkit.broadcastMessage(ColorTranslateUtil.getColor(Main.plugin.getConfig().getString("Messages.Prefix")+Main.plugin.getConfig().getString("Messages.StartEvent")));
            }
        }else {
            Player p = (Player) commandSender;
            p.sendMessage(ColorTranslateUtil.getColor(Main.plugin.getConfig().getString("Messages.Prefix")+Main.plugin.getConfig().getString("Messages.UnknowCommand")));
        }
        return false;
    }
}
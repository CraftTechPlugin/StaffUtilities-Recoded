package it.gramdeveloment.staffutilities.Commands;

import it.gramdeveloment.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static it.gramdeveloment.staffutilities.Main.plugin;

public class Gmc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("staffutilities.gmc") || p.hasPermission("staffutilities.*")) {
                if (p.getGameMode() == GameMode.CREATIVE) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ColorTranslateUtil.getColor(plugin.getConfig().getString("Messages.Prefix")+plugin.getConfig().getString("Messages.GmcOff")));
                }
                else if (p.getGameMode() == GameMode.SURVIVAL) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(ColorTranslateUtil.getColor(plugin.getConfig().getString("Messages.Prefix")+plugin.getConfig().getString("Messages.GmcOn")));
                }
            }else {
                p.sendMessage(ColorTranslateUtil.getColor(plugin.getConfig().getString("Messages.Prefix")+plugin.getConfig().getString("Messages.UnknowCommand")));
            }
        }
        return false;
    }
}

package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gmc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("staffutilities.gmc") || p.hasPermission("staffutilities.*")) {
                if (p.getGameMode() == GameMode.CREATIVE) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ColorTranslateUtil.getColor(Main.plugin.getConfig().getString("Messages.Prefix")+ Main.plugin.getConfig().getString("Messages.GmcOff")));
                }
                else if (p.getGameMode() == GameMode.SURVIVAL) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(ColorTranslateUtil.getColor(Main.plugin.getConfig().getString("Messages.Prefix")+ Main.plugin.getConfig().getString("Messages.GmcOn")));
                }
            }else {
                p.sendMessage(ColorTranslateUtil.getColor(Main.plugin.getConfig().getString("Messages.Prefix")+ Main.plugin.getConfig().getString("Messages.UnknowCommand")));
            }
        }
        return false;
    }
}

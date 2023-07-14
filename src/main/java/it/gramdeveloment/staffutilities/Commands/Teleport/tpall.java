package it.gramdeveloment.staffutilities.Commands.Teleport;

import it.gramdeveloment.staffutilities.Main;
import it.gramdeveloment.staffutilities.Utils.ColorTranslateUtil;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.libs.kyori.adventure.audience.Audience;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpall implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("staffutilities.tpall") || p.hasPermission("staffutilities.*")) {
                if (strings[0].length() == 0) {
                    p.sendMessage(ColorTranslateUtil.getColor("&cInsert a player!"));
                } else {
                    Player all = (Player) Bukkit.getOnlinePlayers();
                    all.teleport(p);
                    String without = ColorTranslateUtil.getColor(Main.getInstance().getConfig().getString("Messages.TpAll"))
                            .replaceAll("%player%", p.getName());
                    String with = PlaceholderAPI.setPlaceholders(p, without);
                    p.sendMessage(ColorTranslateUtil.getColor(Main.getInstance().getConfig().getString("Messages.Prefix") + with));
                }
            } else {
                p.sendMessage(ColorTranslateUtil.getColor(Main.getInstance().getConfig().getString("Messages.Prefix") + Main.getInstance().getConfig().getString("Messages.UnknowCommand")));
            }
        } else {
            commandSender.sendMessage("Only players can execute this command!");
        }
        return false;
    }
}
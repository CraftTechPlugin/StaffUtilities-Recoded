package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.io.File;

public class StartEvent implements CommandExecutor {
    private File msgf;
    private FileConfiguration msg;


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("staffutilities.startevent")) {
                p.getWorld().spawnEntity(p.getLocation(), EntityType.LIGHTNING);
                p.getWorld().spawnEntity(p.getLocation(), EntityType.LIGHTNING);
                p.getWorld().spawnEntity(p.getLocation(), EntityType.GIANT);
                Bukkit.broadcastMessage(ColorTranslateUtil.getColor(Main.plugin.getConfig().getString("Messages.Prefix")+Main.plugin.getConfig().getString("Messages.StartEvent")));
            }else{
                commandSender.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
            }
        }else{
            commandSender.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
        }
        return false;
    }
}
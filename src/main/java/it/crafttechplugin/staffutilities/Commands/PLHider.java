package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.io.File;

import static org.bukkit.Bukkit.getServer;

public class PLHider implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration msg = Main.msg;
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            PluginManager pm = getServer().getPluginManager();
            if(p.hasPermission("staffutilities.plhider")) {
                String placeholderPlugins = Main.plugin.getConfig().getString("Messages.PLHiderOff");
                p.sendMessage(ColorTranslateUtil.getColor(placeholderPlugins));

                for (Plugin plugins : pm.getPlugins()) {
                    ChatColor color;

                    // Verifica se il plugin è abilitato
                    if (Main.plugin.isEnabled()) {
                        color = ChatColor.AQUA;
                    } else {
                        color = ChatColor.RED;
                    }
                    p.sendMessage(color + plugins.getName());
                }
            } else {
                p.sendMessage(ColorTranslateUtil.getColor(Main.plugin.getConfig().getString("Messages.PLHider")));
            }
        } else {
            PluginManager pm = getServer().getPluginManager();
            String placeholderPlugins = Main.plugin.getConfig().getString("Messages.PLHiderOff");
            commandSender.sendMessage(ColorTranslateUtil.getColor(placeholderPlugins));

            for (Plugin plugins : pm.getPlugins()) {
                ChatColor color;

                // Verifica se il plugin è abilitato
                if (Main.plugin.isEnabled()) {
                    color = ChatColor.AQUA;
                } else {
                    color = ChatColor.RED;
                }
                commandSender.sendMessage(color + plugins.getName());
            }
        }
        return false;
    }


}
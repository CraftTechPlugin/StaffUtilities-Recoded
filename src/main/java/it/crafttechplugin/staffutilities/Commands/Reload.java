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

public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration msg = Main.msg;
        Player p = (Player) commandSender;
        if (p.hasPermission("staffutilities.reload")){
            Main.getInstance().reloadConfig();
            p.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.reload")));
        }

        return false;
    }
}

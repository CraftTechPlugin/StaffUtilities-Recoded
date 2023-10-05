package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Color;
import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class EnderChest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Message.NO_PERMS.toString());
            return false;
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("staffutilities.enderchest.self")) {
                if (args.length == 0) {
                    p.openInventory(p.getEnderChest());
                }else {
                    p.openInventory(p.getEnderChest());
                }
            } else if (p.hasPermission("staffutilities.enderchest.other")) {
                if (args.length == 0) {
                    if(p.hasPermission("staffutilities.enderchest.self")){
                        p.openInventory(p.getEnderChest());
                    }
                } else {
                    Player t = Bukkit.getPlayer(args[0]);
                    p.openInventory(t.getEnderChest());
                }
            }else {
                sender.sendMessage(Message.NO_PERMS.toString());
            }
        }

        return false;
    }
}

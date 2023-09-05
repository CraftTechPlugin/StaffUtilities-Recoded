package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Colors;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class EnderChest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        FileConfiguration msg = Main.msg;
        if(!(sender instanceof Player)) {
            sender.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
            return false;
        }
        else {
            Player p = (Player) sender;
            if (p.hasPermission("staffutilities.enderchest.self")) {
                if (args.length == 0) {
                    p.openInventory(p.getEnderChest());
                }
                if (args.length >= 3){
                    String pc = p.getName();
                    if (args[0].equalsIgnoreCase(pc)){
                        p.openInventory(p.getEnderChest());
                    }
                }
            } else if (p.hasPermission("staffutilities.enderchest.other")) {
                if (args.length == 0) {
                    sender.sendMessage(Colors.getColor(msg.getString("Messages.Prefix")) + msg.getString("Messages.noArgs"));
                } else if (args.length >= 3) {
                    Player t = Bukkit.getPlayer(args[0]);
                    p.openInventory(t.getEnderChest());
                }
            }else {
                sender.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
            }
        }

        return false;
    }
}

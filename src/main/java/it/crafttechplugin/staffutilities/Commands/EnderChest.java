package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class EnderChest implements CommandExecutor {
    private File msgf;
    private FileConfiguration msg;


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
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
                    sender.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix")) + msg.getString("Messages.noArgs"));
                } else if (args.length >= 3) {
                    Player t = Bukkit.getPlayer(args[0]);
                    p.openInventory(t.getEnderChest());
                }
            }
        }

        return false;
    }
}

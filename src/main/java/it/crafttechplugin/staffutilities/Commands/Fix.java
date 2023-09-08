package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Colors;
import it.crafttechplugin.staffutilities.listeners.RepairListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Fix implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration msg = Main.msg;
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if (strings[0].length() == 0) {
                if(p.hasPermission("staffutilities.fix")){
                    RepairListener.repairHand(p);
                    p.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.ItemFixed")));
                }else{
                    p.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
                }
            }else{
                if(strings[0].equalsIgnoreCase("fixall")){
                    if(p.hasPermission("staffutilities.fixall")) {
                        RepairListener.repairAll(p);
                        p.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.InventoryFixed")));
                    }
                }else{
                    p.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
                }
            }
        }else{
            commandSender.sendMessage("Only players can execute this command");
        }
        return false;
    }
}

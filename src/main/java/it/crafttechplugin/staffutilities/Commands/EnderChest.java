package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EnderChest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(strings.length == 0){
                if(player.hasPermission("staffutilities.enderchest.self")){
                    Inventory playerEnderchest = player.getEnderChest();
                    player.openInventory(playerEnderchest);
                }else{
                    player.sendMessage(Message.NO_PERMS.toString());
                }
            }else{
                Player target = Bukkit.getPlayer(strings[0]);
                if(target == null){
                    player.sendMessage(Message.OFFLINE_PLAYER.toString());
                }else{
                    if(player.hasPermission("staffutilities.enderchest.other")){
                        Inventory targetEnderchest = target.getEnderChest();
                        player.openInventory(targetEnderchest);
                    }else{
                        player.sendMessage(Message.NO_PERMS.toString());
                    }
                }
            }
        }else{
            sender.sendMessage(Message.NO_PERMS.toString());
        }
        return false;
    }
}

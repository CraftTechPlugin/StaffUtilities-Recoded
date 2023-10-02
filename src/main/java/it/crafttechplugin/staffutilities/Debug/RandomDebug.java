package it.crafttechplugin.staffutilities.Debug;

import it.crafttechplugin.staffutilities.Utils.Color;
import it.crafttechplugin.staffutilities.customApi.randomTpApi;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static it.crafttechplugin.staffutilities.customApi.randomTpApi.randomtp;

public class RandomDebug implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            randomtp(p);
            p.sendMessage(Color.getColor("&c&lDEBUG ESEGUITO"));
        }
        return false;
    }
}

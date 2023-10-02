package it.crafttechplugin.staffutilities.customApi;

import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static it.crafttechplugin.staffutilities.Commands.Vanish.invisible_list;

public class vanishApi {

    public static void enableVanish(Player player){
        invisible_list.add(player);
        player.sendMessage(Message.VANISH_ON.toString());
        for(Player onlinePlayers : Bukkit.getOnlinePlayers()){
            if(!onlinePlayers.hasPermission("staffutilities.vanish.see")){
                onlinePlayers.hidePlayer(player);
            }
        }
    }

    public static void disableVanish(Player player){
        invisible_list.remove(player);
        player.sendMessage(Message.VANISH_OFF.toString());
        for(Player onlinePlayers : Bukkit.getOnlinePlayers()){
            onlinePlayers.showPlayer(player);
        }
    }
}

package it.crafttechplugin.staffutilities.customApi;

import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class randomTpApi {
    public static boolean randomtp(Player player){
        Random random = new Random();
        List<Player> onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
        onlinePlayers.remove(player);
        if(onlinePlayers.isEmpty()){
            player.sendMessage(Message.OFFLINE_PLAYER.toString());
            return false;
        }
        int randomIndex = random.nextInt(onlinePlayers.size());
        Player target = onlinePlayers.get(randomIndex);
        player.teleport(target.getLocation());
        return false;
    }
}

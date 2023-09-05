package it.crafttechplugin.staffutilities.infos;

import it.crafttechplugin.staffutilities.Main;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerInfos {

    public static final String TABLE = "player_infos";

    public void update(Player player) {
        Main.getInstance().cache.addInfo(player.getName(), player.getUniqueId());

    }

    public boolean exist(String playerName) {
        return Main.getInstance().cache.existInfo(playerName);
    }

    public UUID getUuid(String playerName) {
        return Main.getInstance().cache.getUuid(playerName);
    }

}
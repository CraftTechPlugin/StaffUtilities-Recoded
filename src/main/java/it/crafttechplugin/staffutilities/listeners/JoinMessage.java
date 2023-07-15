package it.crafttechplugin.staffutilities.listeners;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.UpdateCheck.UpdateChecker;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        if (p.hasPermission("staffutilities.updatecheck") || p.hasPermission("staffutilities.*")) {

            new UpdateChecker(Main.plugin, 108874).getLastestVersion(version -> {

                if (Main.getInstance().getDescription().getVersion().equalsIgnoreCase(version)) {

                    p.sendMessage(ColorTranslateUtil.getColor("&b&lSTAFFUTILITIES &8» &bAn update was found!"));

                    p.sendMessage(ColorTranslateUtil.getColor("&7(https://www.spigotmc.org/resources/108874/)"));

                } else {

                    p.sendMessage(ColorTranslateUtil.getColor("&b&lSTAFFUTILITIES &8» &bAn update was found!"));

                    p.sendMessage(ColorTranslateUtil.getColor("&7(https://www.spigotmc.org/resources/108874/)"));
                }
            });
        }
    }

}

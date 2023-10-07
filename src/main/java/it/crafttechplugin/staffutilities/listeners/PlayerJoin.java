package it.crafttechplugin.staffutilities.listeners;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.infos.PlayerInfos;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import static it.crafttechplugin.staffutilities.Commands.SpyCommand.spylogs;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        PlayerInfos playerInfos = Main.getInstance().playerInfos;

        playerInfos.update(player);

        if(e.getPlayer().hasPermission("staffutilities.spy")){
            spylogs.add(player);
        }
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        Player player = e.getPlayer();

        Main.getInstance().banManager.checkDuration(player.getUniqueId());

        if(Main.getInstance().banManager.isBanned(player.getUniqueId())) {

            e.setResult(PlayerLoginEvent.Result.KICK_BANNED);
            e.setKickMessage("§cYou are banned from this server!\n " +
                    "\n " +
                    "§6Reason : §f" + Main.getInstance().banManager.getReason(player.getUniqueId()) + "\n " +
                    "\n " +
                    "§aTime left : §f" + Main.getInstance().banManager.getTimeLeft(player.getUniqueId()));
        }
    }

}
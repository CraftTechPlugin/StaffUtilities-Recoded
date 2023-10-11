package it.crafttechplugin.staffutilities.screenshare;

import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ss implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("staffutilities.screenshare.ss")) {
            if (args.length != 0) {
                try {
                    Player staffer = (Player) sender;
                    Player player = Bukkit.getPlayer(args[0]);
                    if (staffer == player) {
                        staffer.sendMessage(Message.SCREENSHARE_BYPASS.toString());
                        return false;
                    }
                    if (Utils.getHackcontrol().containsKey(staffer) || Utils.getHackcontrol().containsValue(player)) {
                        sender.sendMessage(Message.SCREENSHARE_BYPASS.toString());
                        return false;
                    }
                    if (player.isOnline()) {
                        Utils.newHackcontrol(staffer, player);
                        HackControl staffer_t = new HackControl(staffer, (short)0);
                        staffer_t.start();
                        HackControl player_t = new HackControl(player, (short)1);
                        player_t.start();
                    } else {
                        staffer.sendMessage(Message.OFFLINE_PLAYER.toString());
                    }
                } catch (Exception e) {
                    sender.sendMessage(Message.OFFLINE_PLAYER.toString());
                }
            } else {
                sender.sendMessage(Message.NO_ARGS.toString());
            }
        } else {
            sender.sendMessage(Message.NO_PERMS.toString());
        }
        return false;
    }
}

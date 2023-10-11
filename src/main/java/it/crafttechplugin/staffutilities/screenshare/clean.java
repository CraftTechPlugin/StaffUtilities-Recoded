package it.crafttechplugin.staffutilities.screenshare;

import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class clean implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("staffutilities.screenshare.clean")) {
            Player staff = (Player) sender;
            if (Utils.getHackcontrol().containsKey(staff)) {
                Utils.terminateHackControl(staff);
            } else {
                sender.sendMessage(Message.NOTINSCREENSHARE.toString());
            }
        } else {
            sender.sendMessage(Message.NO_PERMS.toString());
        }
        return false;
    }
}

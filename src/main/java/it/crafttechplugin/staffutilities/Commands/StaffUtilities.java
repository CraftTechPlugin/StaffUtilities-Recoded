package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Utils.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StaffUtilities implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        sender.sendMessage(Color.getColor("&b&lSTAFF UTILITIES HELP: " +
                "\n &b/tp <player>" +
                "\n &b/tphere <player>" +
                "\n &b/tpall" +
                "\n &b/enderchest (/ec) <player>" +
                "\n &b/fly" +
                "\n &b/freeze <player>" +
                "\n &b/gmc" +
                "\n &b/invsee <player>" +
                "\n &b/ban <player> <time/perm> <time unit>" +
                "\n &b/unban <player>" +
                "\n &b/mute <player> <time/perm> <time unit>" +
                "\n &b/unmute <player>" +
                "\n &b/msg <player> <message>" +
                "\n &b/report <player> <reason>" +
                "\n &b/staffutilities" +
                "\n &b/vanish (/v)"));
        return false;
    }
}

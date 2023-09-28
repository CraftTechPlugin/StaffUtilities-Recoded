package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Color;
import it.crafttechplugin.staffutilities.Utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;

import static it.crafttechplugin.staffutilities.customApi.vanishApi.disableVanish;
import static it.crafttechplugin.staffutilities.customApi.vanishApi.enableVanish;

public class Vanish implements CommandExecutor, Listener {


    public static ArrayList<Player> invisible_list = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("staffutilities.vanish.use")) {
                if (strings.length == 0) {
                    if (invisible_list.contains(p)) {
                        enableVanish(p);
                    } else if (!invisible_list.contains(p)) {
                        disableVanish(p);
                    }
                } else {
                    Player target = Bukkit.getPlayer(strings[0]);
                    if (target == null) {
                        p.sendMessage(Message.PREFIX.toString() + Message.OFFLINE_PLAYER);
                    } else {
                        if (invisible_list.contains(target)) {
                            disableVanish(target);
                        } else if (!invisible_list.contains(target)) {
                            enableVanish(p);
                        }
                    }
                }
            } else {
                p.sendMessage(Message.PREFIX.toString() + Message.NO_PERMS);
            }
        } else {
            commandSender.sendMessage(Message.PREFIX.toString() + Message.NO_PERMS);
        }
        return true;
    }
}

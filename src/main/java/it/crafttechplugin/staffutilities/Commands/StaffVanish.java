package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Utils.Color;
import it.crafttechplugin.staffutilities.Utils.Message;
import me.frep.vulcan.api.VulcanAPI;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static it.crafttechplugin.staffutilities.Commands.SpyCommand.spylogs;
import static it.crafttechplugin.staffutilities.Main.msg;

public class StaffVanish implements CommandExecutor {
    public static ArrayList<Player> svlist = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("staffutilities.staffvanish")) {
                if(svlist.contains(p)){
                    svlist.remove(p);
                    if(!p.hasPermission("luckperms.log.notify")){
                        User user = LuckPermsProvider.get().getUserManager().getUser(p.getUniqueId());
                        user.data().add(Node.builder("luckperms.log.notify").build());
                        LuckPermsProvider.get().getUserManager().saveUser(user);
                    }
                    if(!VulcanAPI.Factory.getApi().hasAlertsEnabled(p)){
                        VulcanAPI.Factory.getApi().toggleAlerts(p);
                    }
                    spylogs.add(p);
                    p.sendMessage(Message.STAFF_MODE_OFF.toString());
                }else{
                    svlist.add(p);
                    if(p.hasPermission("luckperms.log.notify")){
                        User user = LuckPermsProvider.get().getUserManager().getUser(p.getUniqueId());
                        user.data().remove(Node.builder("luckperms.log.notify").build());
                        LuckPermsProvider.get().getUserManager().saveUser(user);
                    }
                    if(VulcanAPI.Factory.getApi().hasAlertsEnabled(p)){
                        VulcanAPI.Factory.getApi().toggleAlerts(p);
                    }
                    spylogs.remove(p);
                    p.sendMessage(Message.STAFF_VANISH_ON.toString());
                }
            } else {
                p.sendMessage(Message.NO_PERMS.toString());
            }
        } else {
            sender.sendMessage(Message.NO_PERMS.toString());
        }
        return false;
    }
}

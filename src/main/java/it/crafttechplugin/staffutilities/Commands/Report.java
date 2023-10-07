package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Utils.Message;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Report implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("staffutlitities.report.use")){
                String sm = "";
                for(int i = 1; i < strings.length;i++) {
                    String arg = (strings[i] + " ");
                    sm = (sm + arg);
                }
                if(strings[0].length() == 0){
                    p.sendMessage(Message.NO_ARGS.toString());
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    if(target == null){
                        p.sendMessage(Message.OFFLINE_PLAYER.toString());
                    }else{
                        if(strings[1].length() == 0){
                            p.sendMessage(Message.NO_ARGS.toString());
                        }else if(strings[1] == s){
                            p.sendMessage(Message.REPORT_SUCCESS.toString());
                            for(Player people : Bukkit.getOnlinePlayers()){
                                if(people.hasPermission("staffutilies.report.see")){
                                    String without = Message.REPORT_RECEIVED.toString()
                                            .replaceAll("%target%", target.getName());
                                    String with = PlaceholderAPI.setPlaceholders(target, without);
                                    people.sendMessage(with);
                                }
                            }
                        }
                    }
                }
            }else{
                p.sendMessage(Message.NO_PERMS.toString());
            }
        }else{
            sender.sendMessage(Message.NO_PERMS.toString());
        }
        return false;
    }
}

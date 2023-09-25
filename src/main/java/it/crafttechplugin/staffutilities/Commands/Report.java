package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Color;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Report implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration msg = Main.msg;
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(p.hasPermission("staffutlitities.report.use")){
                String sm = "";
                for(int i = 1; i < strings.length;i++) {
                    String arg = (strings[i] + " ");
                    sm = (sm + arg);
                }
                if(strings[0].length() == 0){
                    p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noArgs")));
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    if(!target.isOnline()){
                        p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.OfflinePlayer")));
                    }else{
                        if(strings[1].length() == 0){
                            p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noArgs")));
                        }else if(strings[1] == s){
                            p.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.ReportSuccess")));
                            for(Player people : Bukkit.getOnlinePlayers()){
                                if(people.hasPermission("staffutilies.report.see")){
                                    String without = Color.getColor(msg.getString("Messages.ReportReceived"))
                                            .replaceAll("%target%", target.getName());
                                    String with = PlaceholderAPI.setPlaceholders(target, without);
                                    people.sendMessage(Color.getColor(msg.getString("Messages.Prefix")+with));
                                }
                            }
                        }
                    }
                }
            }else{
                commandSender.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
            }
        }else{
            commandSender.sendMessage("Only players can execute this command");
        }
        return false;
    }
}

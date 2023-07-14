package it.crafttechplugin.staffutilities.Commands.Teleport;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class tphere implements CommandExecutor {
    YamlConfiguration msg = (YamlConfiguration) Main.data;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(p.hasPermission("staffutilities.tphere")){
                if(strings[0].length() == 0){
                    p.sendMessage(ColorTranslateUtil.getColor(Main.getInstance().getConfig().getString("Messages.Prefix") + Main.getInstance().getConfig().getString("Messages.noArguments")));
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    target.teleport(p);
                    String without = ColorTranslateUtil.getColor(msg.getString("Messages.Tp"))
                            .replaceAll("%player%", p.getName());
                    String with = PlaceholderAPI.setPlaceholders(p, without);
                    p.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix")+with));
                }
            }else{
                commandSender.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
            }
        }else{
            commandSender.sendMessage(ColorTranslateUtil.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
        }
        return false;
    }
}
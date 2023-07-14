package it.crafttechplugin.staffutilities.Commands.Teleport;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(p.hasPermission("staffutilities.tp") || p.hasPermission("staffutilities.*")){
                if(strings[0].length() == 0){
                    p.sendMessage(ColorTranslateUtil.getColor("&cInsert a player!"));
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    p.teleport(target);
                    String without = ColorTranslateUtil.getColor(Main.getInstance().getConfig().getString("Messages.Tp"))
                            .replaceAll("%player%", p.getName());
                    String with = PlaceholderAPI.setPlaceholders(p, without);
                    p.sendMessage(ColorTranslateUtil.getColor(Main.getInstance().getConfig().getString("Messages.Prefix")+with));
                }
            }else{
                p.sendMessage(ColorTranslateUtil.getColor(Main.getInstance().getConfig().getString("Messages.Prefix")+Main.getInstance().getConfig().getString("Messages.UnknowCommand")));
            }
        }else{
            commandSender.sendMessage("Only players can execute this command");
        }
        return false;
    }
}

package it.crafttechplugin.staffutilities.Commands.Teleport;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tphere implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(p.hasPermission("staffutilities.tphere")){
                if(strings[0].length() == 0){
                    p.sendMessage(ColorTranslateUtil.getColor("&cInsert a player!"));
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    target.teleport(p);
                    String without = ColorTranslateUtil.getColor(Main.getInstance().getConfig().getString("Messages.TpHere"))
                            .replaceAll("%player%", p.getName());
                    String with = PlaceholderAPI.setPlaceholders(p, without);
                    p.sendMessage(ColorTranslateUtil.getColor(Main.getInstance().getConfig().getString("Messages.Prefix") + with));
                }
            }else{
                p.sendMessage(ColorTranslateUtil.getColor(Main.getInstance().getConfig().getString("Messages.Prefix") + Main.getInstance().getConfig().getString("Messages.UnknowCommand")));
            }
        }else{
            commandSender.sendMessage("Only players can execute this command");
        }
        return false;
    }
}
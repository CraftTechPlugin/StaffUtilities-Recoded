package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class StaffUtilitiesCommand implements CommandExecutor {

    private Main plugin;

    public StaffUtilitiesCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        FileConfiguration msg = Main.msg;
        if (args.length == 0) {
            if(commandSender instanceof Player){
                Player p = (Player) commandSender;
                p.sendMessage(Color.getColor("&b&lSTAFFUTILITIES by CraftTechPlugin"));
                if( p.hasPermission("staffutilities.help")){
                    p.sendMessage("");
                    p.sendMessage(Color.getColor("&b&lCOMMANDS"));
                    p.sendMessage(Color.getColor("&b/fly &7(Toggle fly mode)"));
                    p.sendMessage(Color.getColor("&b/pl &7(Show the plugin list if you have the permission)"));
                    p.sendMessage(Color.getColor("&b/plugins &7(Show the plugin list if you have the permission)"));
                    p.sendMessage(Color.getColor("&b/staffutilities &7(Show this message)"));
                    p.sendMessage(Color.getColor("&b/startevent &7(Start the server opening event)"));
                    p.sendMessage(Color.getColor("&b/vanish &7(Toggle vanish)"));
                    p.sendMessage(Color.getColor("&b/gmc &7(Toggle creative gamemode)"));
                    p.sendMessage(Color.getColor("&b/tp &7(Teleports you from another player)"));;
                    p.sendMessage(Color.getColor("&b/tphere &7(Teleports a player to you)"));
                    p.sendMessage(Color.getColor("&b/freeze &7(Freeze a player)"));
                    p.sendMessage(Color.getColor("&b/creload &7(Reload config.yml)"));
                    p.sendMessage(Color.getColor("&b/staffvanish &7(Toggle staffvanish)"));
                }
            }else{
                commandSender.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
            }
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("help")) {
                if(commandSender instanceof Player){
                    Player p = (Player) commandSender;
                    p.sendMessage(Color.getColor("&b&lSTAFFUTILITIES by CraftTechPlugin"));
                    if( p.hasPermission("staffutilities.help")){
                        p.sendMessage("");
                        p.sendMessage(Color.getColor("&b&lCOMMANDS"));
                        p.sendMessage(Color.getColor("&b/fly &7(Toggle fly mode)"));
                        p.sendMessage(Color.getColor("&b/pl &7(Show the plugin list if you have the permission)"));
                        p.sendMessage(Color.getColor("&b/plugins &7(Show the plugin list if you have the permission)"));
                        p.sendMessage(Color.getColor("&b/staffutilities &7(Show this message)"));
                        p.sendMessage(Color.getColor("&b/startevent &7(Start the server opening event)"));
                        p.sendMessage(Color.getColor("&b/vanish &7(Toggle vanish)"));
                        p.sendMessage(Color.getColor("&b/gmc &7(Toggle creative gamemode)"));
                        p.sendMessage(Color.getColor("&b/tp &7(Teleports you from another player)"));;
                        p.sendMessage(Color.getColor("&b/tphere &7(Teleports a player to you)"));
                        p.sendMessage(Color.getColor("&b/freeze &7(Freeze a player)"));
                        p.sendMessage(Color.getColor("&b/creload &7(Reload config.yml)"));
                        p.sendMessage(Color.getColor("&b/staffvanish &7(Toggle staffvanish)"));
                    }
                }else{
                    commandSender.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
                }
            }
            if (args[0].equalsIgnoreCase("reload")) {
                if (commandSender instanceof Player) {
                    if (commandSender.hasPermission("staffutilities.reload")){
                        plugin.getServer().getScheduler().cancelTasks(plugin);
                        plugin.reloadConfig();
                        plugin.createFiles();
                        commandSender.sendMessage(Color.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.reload")));
                    }
                }
            }
        }
        return false;
    }
}

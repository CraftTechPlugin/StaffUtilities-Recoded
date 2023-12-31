package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.TimeUnit;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.UUID;

public class Moderation implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("ban")) {
            if(!sender.hasPermission("staffutilities.ban")) {
                return true;
            }

            if(args.length < 3) {
                helpMessage(sender);
                return true;
            }

            String targetName = args[0];

            if(!Main.getInstance().playerInfos.exist(targetName)) {
                sender.sendMessage("§cThis player is never came on this server.");
                return true;
            }

            UUID uuid = Main.getInstance().playerInfos.getUuid(targetName);

            if(Main.getInstance().banManager.isBanned(uuid)) {
                sender.sendMessage("§cThis player is already banned!");
                return true;
            }

            String reason = "";
            for(int i = 2; i < args.length; i++) {
                reason += args[i] + " ";
            }

            if(args[1].equalsIgnoreCase("perm")) {
                Main.getInstance().banManager.ban(uuid, -1, reason);
                sender.sendMessage("§cYou banned §6" + Bukkit.getOfflinePlayer(uuid).getName() + " §c(Permanent) §afor : §e" + reason);
                return true;
            }

            if(!args[1].contains(":")) {
                helpMessage(sender);
                return true;
            }

            int duration = 0;
            try {
                duration = Integer.parseInt(args[1].split(":")[0]);
            } catch (NumberFormatException e) {
                sender.sendMessage("§cValue 'duration' must be a number.");
                return true;
            }

            if(!TimeUnit.existFromShortcut(args[1].split(":")[1])) {
                sender.sendMessage("§cThis time unit doesn't exist.");
                sender.sendMessage("§6--------------------");
                for(TimeUnit units : TimeUnit.values()) {
                    sender.sendMessage("§c" + units.getName() + "§7: " + units.getShortcut());
                }
                sender.sendMessage("§6--------------------");
                return true;
            }

            TimeUnit unit = TimeUnit.getFromShortcut(args[1].split(":")[1]);
            long banTime = unit.getToSecond() * duration;

            Main.getInstance().banManager.ban(uuid, banTime, reason);
            sender.sendMessage("§cYou banned §6" + Bukkit.getOfflinePlayer(uuid).getName() + " §c(" + duration + " " + unit.getName() + ") §afor : §e" + reason);
            return true;
        }

        if(label.equalsIgnoreCase("unban")) {
            if(!sender.hasPermission("unban")) {
                return true;
            }

            if(args.length != 1) {
                sender.sendMessage("§c/unban <player>");
                return true;
            }

            String targetName = args[0];

            if(!Main.getInstance().playerInfos.exist(targetName)) {
                sender.sendMessage("§cThis player is never came on this server.");
                return true;
            }

            UUID uuid = Main.getInstance().playerInfos.getUuid(targetName);

            if(!Main.getInstance().banManager.isBanned(uuid)) {
                sender.sendMessage("§cThis player isn't banned!");
                return true;
            }

            Main.getInstance().banManager.unban(uuid);
            sender.sendMessage("§aYou unbanned §6" + Bukkit.getOfflinePlayer(uuid).getName());
            return true;
        }

        if(label.equalsIgnoreCase("mute")) {
            if(!sender.hasPermission("mute")) {
                return true;
            }

            if(args.length < 2) {
                sender.sendMessage("§6--------------------");
                sender.sendMessage("§c/mute <player> perm");
                sender.sendMessage("§c/mute <player> <duration>:<time unit>");
                sender.sendMessage("§6--------------------");
                return true;
            }

            String targetName = args[0];

            if(!Main.getInstance().playerInfos.exist(targetName)) {
                sender.sendMessage("§cThis player is never came on this server.");
                return true;
            }

            UUID uuid = Main.getInstance().playerInfos.getUuid(targetName);

            if(Main.getInstance().muteManager.isMuted(uuid)) {
                sender.sendMessage("§cThis player is already muted!");
                return true;
            }

            if(args[1].equalsIgnoreCase("perm")) {
                Main.getInstance().muteManager.mute(uuid, -1);
                sender.sendMessage("§cYou muted §6" + Bukkit.getOfflinePlayer(uuid).getName() + " §c(Permanent)");
                return true;
            }

            if(!args[1].contains(":")) {
                sender.sendMessage("§6--------------------");
                sender.sendMessage("§c/mute <player> perm");
                sender.sendMessage("§c/mute <player> <duration>:<time unit>");
                sender.sendMessage("§6--------------------");
                return true;
            }

            int duration = 0;
            try {
                duration = Integer.parseInt(args[1].split(":")[0]);
            } catch (NumberFormatException e) {
                sender.sendMessage("§cValue 'duration' must be a number.");
                return true;
            }

            if(!TimeUnit.existFromShortcut(args[1].split(":")[1])) {
                sender.sendMessage("§cThis time unit doesn't exist.");
                sender.sendMessage("§6--------------------");
                for(TimeUnit units : TimeUnit.values()) {
                    sender.sendMessage("§c" + units.getName() + "§7: " + units.getShortcut());
                }
                sender.sendMessage("§6--------------------");
                return true;
            }

            TimeUnit unit = TimeUnit.getFromShortcut(args[1].split(":")[1]);
            long muteTime = unit.getToSecond() * duration;

            Main.getInstance().muteManager.mute(uuid, muteTime);
            sender.sendMessage("§cYou muted §6" + Bukkit.getOfflinePlayer(uuid).getName() + " §c(" + duration + " " + unit.getName() + ")");
            return true;
        }

        if(label.equalsIgnoreCase("unmute")) {
            if(!sender.hasPermission("unmute")) {
                return true;
            }

            if(args.length != 1) {
                sender.sendMessage("§c/unmute <player>");
                return true;
            }

            String targetName = args[0];

            if(!Main.getInstance().playerInfos.exist(targetName)) {
                sender.sendMessage("§cThis player is never came on this server.");
                return true;
            }

            UUID uuid = Main.getInstance().playerInfos.getUuid(targetName);

            if(!Main.getInstance().muteManager.isMuted(uuid)) {
                sender.sendMessage("§cThis player isn't muted!");
                return true;
            }

            Main.getInstance().muteManager.unmute(uuid);
            sender.sendMessage("§aYou unmuted §6" + Bukkit.getOfflinePlayer(uuid).getName());
            return true;
        }

        if(label.equalsIgnoreCase("bansystem")) {
            if(!sender.hasPermission("bansystem")) {
                return true;
            }

            if(args.length < 1 || args.length > 1) {
                sender.sendMessage("§c/bansystem help");
                return true;
            }

            if(args[0].equalsIgnoreCase("help")) {
                sender.sendMessage("§6--------------------");
                sender.sendMessage("§e/ban <player> perm <reason>§7: Ban permanently");
                sender.sendMessage("§e/ban <player> <duration>:<time unit> <reason>§7: Ban a specified time");
                sender.sendMessage("§e/unban <player>§7: Unban un player");
                sender.sendMessage("§e/bansystem reload§7: Reload the config and save cache");
                sender.sendMessage("§6--------------------");
            } else if(args[0].equalsIgnoreCase("reload")) {
                sender.sendMessage(Main.getInstance().prefix + "§bReloading...");


                if(Main.getInstance().USE_DATABASE)
                    Main.getInstance().initConnection();

                Main.getInstance().cache.update();

                sender.sendMessage(Main.getInstance().prefix + "§aSuccessful reloading!");
            }
        }

        return false;
    }

    public void helpMessage(CommandSender sender) {
        sender.sendMessage("§6--------------------");
        sender.sendMessage("§c/ban <player> perm <reason>");
        sender.sendMessage("§c/ban <player> <duration>:<time unit> <reason>");
        sender.sendMessage("§6--------------------");
    }
}
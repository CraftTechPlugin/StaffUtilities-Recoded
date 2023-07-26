package it.crafttechplugin.staffutilities.Commands;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Colors;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import java.util.ArrayList;

public class Freeze implements CommandExecutor, Listener {
    public static final ArrayList<Player> freeze_list = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration msg = Main.msg;
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(p.hasPermission("staffutlities.freeze")){
                if(strings[0].length() == 0){
                    p.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noArgs")));
                }else{
                    Player target = Bukkit.getPlayer(strings[0]);
                    if (target == null){
                        p.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.OfflinePlayer")));
                    }else{
                        if(freeze_list.contains(target)){
                            freeze_list.remove(target);
                            p.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.FreezeOff").replaceAll("%player%", target.getName())));
                        }else{
                            freeze_list.add(target);
                            p.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.FreezeOn").replaceAll("%player%", target.getName())));
                        }
                    }
                }
            }else {
                p.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
            }
        }else{
            commandSender.sendMessage(Colors.getColor(msg.getString("Messages.Prefix") + msg.getString("Messages.noPerms")));
        }
        return false;
    }

    @EventHandler
    public void onItemPick(PlayerPickupItemEvent event){
        Player p = event.getPlayer();
        if(freeze_list.contains(p)){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        Player p = event.getPlayer();
        if (freeze_list.contains(p)) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        Player p = (Player) event.getEntity();
        if(freeze_list.contains(p)){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player p = (Player) event.getPlayer();
        if(freeze_list.contains(p)){
            event.setCancelled(true);
        }else{
            event.setCancelled(false);
        }
    }
}

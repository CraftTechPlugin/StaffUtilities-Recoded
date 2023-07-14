package it.gramdeveloment.staffutilities;

import it.gramdeveloment.staffutilities.Commands.*;
import it.gramdeveloment.staffutilities.Commands.Teleport.*;
import it.gramdeveloment.staffutilities.Events.*;
import it.gramdeveloment.staffutilities.UpdateCheck.*;
import it.gramdeveloment.staffutilities.Utils.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
public final class Main extends JavaPlugin implements Listener {
    public static Main plugin;

    public void onEnable() {
        new UpdateChecker(this, 108874).getLastestVersion(version ->{
            if(this.getDescription().getVersion().equalsIgnoreCase(version)){
                System.out.println(ColorTranslateUtil.getColor("StaffUtilities » An update was found!"));
            }else{
                System.out.println(ColorTranslateUtil.getColor("StaffUtilities » An update was found!"));
            }
        });

        plugin = this;

        getCommand("gmc").setExecutor(new Gmc());
        getCommand("fly").setExecutor(new Fly());
        getCommand("tp").setExecutor(new tp());
        getCommand("tphere").setExecutor(new tphere());
        getCommand("pl").setExecutor(new PLHider());
        getCommand("staffutilities").setExecutor(new StaffUtilitiesCommand());
        getCommand("plugins").setExecutor(new PLHider());
        getCommand("startevent").setExecutor(new StartEvent());
        getCommand("vanish").setExecutor(new Vanish());
        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getPluginManager().registerEvents(this, this);

        getConfig().options().copyDefaults(true);
        saveConfig();
    }


    public static Main getInstance() {
        return plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(p.hasPermission("staffutilities.updatecheck") || p.hasPermission("staffutilities.*")) {
            new UpdateChecker(this, 108874).getLastestVersion(version -> {
                if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                    p.sendMessage(ColorTranslateUtil.getColor("&c&lSTAFF&4&lUTILITIES &8» &cAn update was found!"));
                    p.sendMessage(ColorTranslateUtil.getColor("&4(https://www.spigotmc.org/resources/108874/)"));
                } else {
                    p.sendMessage(ColorTranslateUtil.getColor("&c&lSTAFF&4&lUTILITIES &8» &cAn update was found!"));
                    p.sendMessage(ColorTranslateUtil.getColor("&4(https://www.spigotmc.org/resources/108874/)"));
                }
            });
        }
    }
}

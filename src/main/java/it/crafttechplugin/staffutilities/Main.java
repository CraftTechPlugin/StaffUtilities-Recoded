package it.crafttechplugin.staffutilities;

import it.crafttechplugin.staffutilities.Commands.*;
import it.crafttechplugin.staffutilities.Commands.Teleport.tp;
import it.crafttechplugin.staffutilities.Commands.Teleport.tphere;
import it.crafttechplugin.staffutilities.Events.Events;
import it.crafttechplugin.staffutilities.UpdateCheck.UpdateChecker;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import sun.invoke.empty.Empty;

import java.io.File;

public final class Main extends JavaPlugin implements Listener {

    public static Main plugin;

    public static FileConfiguration data = YamlConfiguration.loadConfiguration(new File(Main.getInstance().getDataFolder(), "locales.En-en.yml"));

    Double configVersion = Main.getInstance().getConfig().getDouble("version");

    public void onEnable() {
        boolean cup = Main.getInstance().getConfig().getBoolean("check-update");
        Double cVersion = 1.0;

        if (cup) {
            new UpdateChecker(this, 108874).getLastestVersion(version ->{

                if(this.getDescription().getVersion().equalsIgnoreCase(version)){

                    System.out.println(ColorTranslateUtil.getColor("StaffUtilities » An update was found!"));

                }else{

                    System.out.println(ColorTranslateUtil.getColor("StaffUtilities » An update was found!"));
                }
            });
            File configFile = new File(this.getDataFolder(), "config.yml");
            if (!(cVersion.equals(configVersion)) || !(configFile.exists())){

                getConfig().options().copyDefaults(true);

                saveConfig();
            }

        }

        plugin = this;

        getCommand("reload").setExecutor(new Reload());

        getCommand("invsee").setExecutor(new InvSee());

        getCommand("enderchest").setExecutor(new EnderChest());

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

                    p.sendMessage(ColorTranslateUtil.getColor("&b&lSTAFFUTILITIES &8» &bAn update was found!"));

                    p.sendMessage(ColorTranslateUtil.getColor("&7(https://www.spigotmc.org/resources/108874/)"));

                } else {

                    p.sendMessage(ColorTranslateUtil.getColor("&b&lSTAFFUTILITIES &8» &bAn update was found!"));

                    p.sendMessage(ColorTranslateUtil.getColor("&7(https://www.spigotmc.org/resources/108874/)"));
                }
            });
        }
    }
}
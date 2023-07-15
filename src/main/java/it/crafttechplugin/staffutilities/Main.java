package it.crafttechplugin.staffutilities;

import it.crafttechplugin.staffutilities.Commands.*;
import it.crafttechplugin.staffutilities.Commands.Teleport.tp;
import it.crafttechplugin.staffutilities.Commands.Teleport.tphere;
import it.crafttechplugin.staffutilities.Events.Events;
import it.crafttechplugin.staffutilities.UpdateCheck.UpdateChecker;
import it.crafttechplugin.staffutilities.Utils.ColorTranslateUtil;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@SuppressWarnings("all")
public final class Main extends JavaPlugin implements Listener {


    public static Main plugin;

    public static File configf, msgf;
    public static FileConfiguration config, msg;

    public void createFiles() {
        configf = new File(getDataFolder(), "config.yml");
        msgf = new File(getDataFolder(), "locales/EN-en.yml");

        if (!configf.exists()) {
            configf.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }

        if (!msgf.exists()) {
            msgf.getParentFile().mkdirs();
            saveResource("locales/EN-en.yml", false);
        }
        config = new YamlConfiguration();
        msg = new YamlConfiguration();


        try {
            msg.load(msgf);
            config.load(configf);
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public void onEnable() {
        createFiles();
        boolean cup = config.getBoolean("check-update");
        Double cVersion = 1.0;

        if (cup) {
            new UpdateChecker(this, 108874).getLastestVersion(version -> {

                if (this.getDescription().getVersion().equalsIgnoreCase(version)) {

                    System.out.println(ColorTranslateUtil.getColor("StaffUtilities » An update was found!"));

                } else {

                    System.out.println(ColorTranslateUtil.getColor("StaffUtilities » An update was found!"));
                }
            });

        }

        plugin = this;

        getCommand("creload").setExecutor(new Reload());

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
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        if (p.hasPermission("staffutilities.updatecheck") || p.hasPermission("staffutilities.*")) {

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

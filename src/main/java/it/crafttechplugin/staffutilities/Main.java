package it.crafttechplugin.staffutilities;

import it.crafttechplugin.staffutilities.Commands.*;
import it.crafttechplugin.staffutilities.Commands.Teleport.tp;
import it.crafttechplugin.staffutilities.Commands.Teleport.tphere;
import it.crafttechplugin.staffutilities.UpdateCheck.UpdateChecker;
import it.crafttechplugin.staffutilities.Utils.Colors;
import it.crafttechplugin.staffutilities.bans.BanManager;
import it.crafttechplugin.staffutilities.cache.Cache;
import it.crafttechplugin.staffutilities.database.MySQL;
import it.crafttechplugin.staffutilities.infos.PlayerInfos;
import it.crafttechplugin.staffutilities.listeners.*;
import it.crafttechplugin.staffutilities.mutes.MuteManager;
import it.crafttechplugin.staffutilities.storage.yml.BanYML;
import it.crafttechplugin.staffutilities.storage.yml.DefaultConfigManager;
import it.crafttechplugin.staffutilities.storage.yml.InfosYML;
import it.crafttechplugin.staffutilities.storage.yml.MuteYML;
import org.apache.commons.dbcp.BasicDataSource;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@SuppressWarnings("all")
public final class Main extends JavaPlugin implements Listener {

    private static Main INSTANCE;
    private BasicDataSource connectionPool;
    private MySQL mysql;
    public BanManager banManager = new BanManager();
    public MuteManager muteManager = new MuteManager();
    public PlayerInfos playerInfos = new PlayerInfos();
    public Cache cache = new Cache();
    public DefaultConfigManager configManager;
    public BanYML banYML;
    public InfosYML infosYML;
    public MuteYML muteYML;

    public static Main plugin;

    public static File configf, msgf;
    public static FileConfiguration config, msg;

    public final String prefix = "§b[StaffUtilities]§r ";

    public boolean USE_DATABASE;
    public String DB_URL;
    public String DB_NAME;
    public String USERNAME;
    public String PASSWORD;
    public String PORT;



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

    public void commands() {
        getCommand("ban").setExecutor(new Moderation());
        getCommand("unban").setExecutor(new Moderation());
        getCommand("mute").setExecutor(new Moderation());
        getCommand("unmute").setExecutor(new Moderation());
        getCommand("bansystem").setExecutor(new Moderation());
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
        getCommand("msg").setExecutor(new Msg());
        getCommand("freeze").setExecutor(new Freeze());
        getCommand("fix").setExecutor(new Fix());
    }

    public void listeners() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new Events(), this);
        pm.registerEvents(new JoinMessage(), this);
        pm.registerEvents(new VanishEvent(), this);
    }

    @Override
    public void onEnable() {
        createFiles();
        boolean cup = config.getBoolean("check-update");
        Double cVersion = 1.0;

        if (cup) {
            new UpdateChecker(this, 108874).getLastestVersion(version -> {

                if (this.getDescription().getVersion().equalsIgnoreCase(version)) {

                    System.out.println(Colors.getColor("StaffUtilities » An update was found!"));

                } else {

                    System.out.println(Colors.getColor("StaffUtilities » An update was found!"));
                }
            });

        }

        plugin = this;

        banYML = new BanYML(this);
        infosYML = new InfosYML(this);
        muteYML = new MuteYML(this);
        FileConfiguration config = Main.config;

        USE_DATABASE = config.getBoolean("db.use_db");
        DB_URL = config.getString("db.url");
        PORT = String.valueOf(config.getInt("db.port"));
        DB_NAME = config.getString("db.db_name");
        USERNAME = config.getString("db.username");
        PASSWORD = config.getString("db.password");

        if(USE_DATABASE)
            initConnection();

        commands();
        listeners();

        cache.update();

        super.onEnable();

    }

    @Override
    public void onDisable() {
      cache.update();

      super.onDisable();
    }

    public void initConnection() {
        if(connectionPool != null) {
            try {
                connectionPool.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }

        connectionPool = new BasicDataSource();
        connectionPool.setDriverClassName("com.mysql.jdbc.Driver");
        connectionPool.setUsername(USERNAME);
        connectionPool.setPassword(PASSWORD);
        connectionPool.setUrl("jdbc:mysql://" + DB_URL + ":" + PORT + "/" + DB_NAME + "?autoReconnect=true");
        connectionPool.setInitialSize(1);
        mysql = new MySQL(connectionPool);
        mysql.createTables();
    }

    public MySQL getMysql() {
        return mysql;
    }

    public static Main getInstance() {
        return plugin;
    }

}

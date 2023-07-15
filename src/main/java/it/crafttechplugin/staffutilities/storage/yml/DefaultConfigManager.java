package it.crafttechplugin.staffutilities.storage.yml;

import it.crafttechplugin.staffutilities.Main;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class DefaultConfigManager {

    private Main plugin;
    private File saveFile;
    private YamlConfiguration config;

    public boolean USE_DATABASE;
    public String DB_URL;
    public String DB_NAME;
    public String USERNAME;
    public String PASSWORD;
    public String PORT;

    public void loadConfig(){
        FileConfiguration config = Main.config;

        USE_DATABASE = config.getBoolean("db.use_db");
        DB_URL = config.getString("db.url");
        PORT = String.valueOf(config.getInt("db.port"));
        DB_NAME = config.getString("db.db_name");
        USERNAME = config.getString("db.username");
        PASSWORD = config.getString("db.password");
    }

}

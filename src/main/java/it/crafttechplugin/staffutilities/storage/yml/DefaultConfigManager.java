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

        final ConfigurationSection section = config.getConfigurationSection("db");

        USE_DATABASE = section.getBoolean("use_db");
        DB_URL = section.getString("url");
        PORT = String.valueOf(section.getInt("port"));
        DB_NAME = section.getString("db_name");
        USERNAME = section.getString("username");
        PASSWORD = section.getString("password");
    }

}

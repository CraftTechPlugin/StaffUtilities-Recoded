package it.crafttechplugin.staffutilities.UpdateCheck;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Color;
import org.bukkit.Bukkit;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public class UpdateChecker {

    private Main plugin;
    private int resourceId;

    public UpdateChecker(Main plugin, int resourceId){
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    public void getLastestVersion(Consumer<String> consumer){
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try(InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId).openStream();
                Scanner scanner = new Scanner(inputStream)){
                if(scanner.hasNext()){
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception){
                plugin.getLogger().info(Color.getColor("&cUpdate not found!") + exception.getMessage());
            }

        });
    }
}

package it.crafttechplugin.staffutilities.Utils;

import org.bukkit.ChatColor;

public class Colors {
    public static String getColor(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}

package it.crafttechplugin.staffutilities.Utils;

import org.bukkit.ChatColor;

public class Color {
    public static String getColor(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}

package it.gramdeveloment.staffutilities.Utils;

import org.bukkit.ChatColor;

public class ColorTranslateUtil {
    public static String getColor(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}

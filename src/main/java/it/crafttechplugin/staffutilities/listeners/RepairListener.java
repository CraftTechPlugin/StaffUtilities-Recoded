package it.crafttechplugin.staffutilities.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class RepairListener {
    public static void repairAll(Player p) {
        byte b;
        int i;
        ItemStack[] arrayOfItemStack;
        for (i = (arrayOfItemStack = p.getInventory().getContents()).length, b = 0; b < i; ) {
            ItemStack itemStack = arrayOfItemStack[b];
            if (itemStack != null) {
                itemStack.setDurability((short) 0);
                Bukkit.getPluginManager().callEvent((Event) new RepairEvent(p, itemStack));
            }
            b++;
        }
    }
    public static void repairHand(Player p) {
        if (p.getInventory().getItemInHand().getType() != null) {
            p.getInventory().getItemInHand().setDurability((short)0);
            Bukkit.getPluginManager().callEvent((Event)new RepairEvent(p, p.getItemInHand()));
        }
    }
}


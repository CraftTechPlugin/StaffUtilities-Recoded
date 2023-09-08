package it.crafttechplugin.staffutilities.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class RepairEvent extends Event {
    private Player p;

    private ItemStack itemStack;

    private static final HandlerList handlers = new HandlerList();

    public RepairEvent(Player p, ItemStack itemStack) {
        this.p = p;
        this.itemStack = itemStack;
    }

    public Player getPlayer() {
        return this.p;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

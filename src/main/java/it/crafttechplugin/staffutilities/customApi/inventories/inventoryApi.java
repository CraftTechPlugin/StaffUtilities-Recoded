package it.crafttechplugin.staffutilities.customApi.inventories;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class inventoryApi {


    public static void setPlayerInventoryItem(Player player, int i, ItemStack itemStack){
        player.getInventory().setItem(i, itemStack);
    }

    public Inventory createInventory(Player player, int size, String title) {
        return Bukkit.createInventory(player, size, title);
    }

}

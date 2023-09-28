package it.crafttechplugin.staffutilities.customApi;

import it.crafttechplugin.staffutilities.Utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class inventoryApi {
    private static ArrayList<String> lores = new ArrayList<>();
    private static ItemStack item;
    private static Inventory inventory;

    public static void setPlayerInventoryItem(Player player, int i, ItemStack itemStack) {
        player.getInventory().setItem(i, itemStack);
    }
    public static void createInventory(Player player, int size) {
        inventory = Bukkit.createInventory(player, size);
    }
    public static void openInventory(Player player) {
        player.openInventory(inventory);
    }
    public static void setItem(ItemStack itemStack, int i) {
        inventory.setItem(i, itemStack);
    }
    public static void createItem(Material material) {
        item = new ItemStack(material);
    }
    public static void setEnchant(Enchantment enchant, int i, boolean response){
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.addEnchant(enchant, i, response);
        item.setItemMeta(itemMeta);
    }
    public static void setDisplayName(String name){
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(Color.getColor(name));
        item.setItemMeta(itemMeta);
    }
    public static void addLore(String lore){
        ItemMeta itemMeta = item.getItemMeta();
        lores.add(lore);
        item.setItemMeta(itemMeta);
    }
    public static void setLore(){
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore(lores);
        item.setItemMeta(itemMeta);
    }
    public static boolean getDisplayName(String name){
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.getDisplayName().equalsIgnoreCase(name);
        return false;
    }
}

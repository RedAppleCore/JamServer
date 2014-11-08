package com.jam2400.jamcade;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CompassMenu {
	public static Inventory getMenu(){
		Inventory menu = Bukkit.createInventory(null, 9, ChatColor.RED + "Menu:");
		return menu;
	}
	public static void openMenu(Player p){
		Inventory menu = getMenu();
		ItemStack wardrobe = new ItemStack(Material.IRON_CHESTPLATE);
		menu.setItem(0, wardrobe);
		p.openInventory(menu);
	}
}

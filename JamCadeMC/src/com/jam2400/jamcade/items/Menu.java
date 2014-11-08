package com.jam2400.jamcade.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Menu {
	public static ItemStack getItem(){
		// MAIN MENU!
		ItemStack menu = new ItemStack(Material.NETHER_STAR);
		//Set info
		ItemMeta menumeta = menu.getItemMeta();
		menumeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Server Selector");
		// Assign
		menu.setItemMeta(menumeta);
		
		return menu;
	}
}

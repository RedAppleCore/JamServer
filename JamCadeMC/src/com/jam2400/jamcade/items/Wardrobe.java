package com.jam2400.jamcade.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Wardrobe {
	public static ItemStack getItem(){
		// WARDROBE!
		ItemStack wardrobe = new ItemStack(Material.IRON_CHESTPLATE);
		// Set information
		ItemMeta meta = wardrobe.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Wardrobe");
		// Assign information
		wardrobe.setItemMeta(meta);
		
		return wardrobe;
	}
}

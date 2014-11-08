package com.jam2400.jamcade.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Cosmetics {
	public static ItemStack getItem(){
	// MAIN MENU!
		ItemStack cosmetic = new ItemStack(Material.PISTON_BASE);
		//Set info
		ItemMeta meta = cosmetic.getItemMeta();
		meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Cosmetics");
		// Assign
		cosmetic.setItemMeta(meta);
			
		return cosmetic;
	}
}

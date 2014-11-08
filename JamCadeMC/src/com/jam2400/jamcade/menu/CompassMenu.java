package com.jam2400.jamcade.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CompassMenu {
	
	public static Inventory getWardrobeMenu(){
		// Initiate wardrobe and give name etc.
		Inventory wardrobe = Bukkit.createInventory(null, 45, ChatColor.GREEN + "Wardrobe:");
		
		// Set items in the wardrobe
		wardrobe.setItem(10, Item.goldChest.getItem());
		wardrobe.setItem(11, Item.ironChest.getItem());
		wardrobe.setItem(12, Item.diamondChest.getItem());
		return wardrobe;
	}
	
	public static void openWardrobe(Player p){
		p.openInventory(getWardrobeMenu());
	}
	
	
	
}

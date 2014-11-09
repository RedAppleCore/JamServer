package com.jam2400.jamcade.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.jam2400.jamcade.items.WardrobeItem;

public class WardrobeMenu {
	
	public static Inventory getWardrobeMenu(){
		// Initiate wardrobe and give name etc.
		Inventory wardrobe = Bukkit.createInventory(null, 9, ChatColor.GREEN + "Wardrobe:");
		
		// Set items in the wardrobe
		for(WardrobeItem i : WardrobeItem.values()){
			int slot = i.getSlot();
			ItemStack item = i.getItem();
			wardrobe.setItem(slot, item);
		}
		return wardrobe;
	}
	
	public static void openWardrobe(Player p){
		p.openInventory(getWardrobeMenu());
	}
	
	
	
}

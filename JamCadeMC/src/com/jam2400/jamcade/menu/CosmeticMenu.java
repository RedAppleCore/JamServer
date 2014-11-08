package com.jam2400.jamcade.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CosmeticMenu {
	public static Inventory getCosmeticMenu(){
		Inventory cosmetics = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "Cosmetics:");
		cosmetics.setItem(1, Item.hats.getItem());
		cosmetics.setItem(2, Item.wardrobe.getItem());
		
		return cosmetics;
	}
	
	public static void openMenu(Player p){
		p.openInventory(getCosmeticMenu());
	}
}

package com.jam2400.jamcade.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.jam2400.jamcade.items.CosmeticItem;

public class CosmeticMenu {
	public static Inventory getCosmeticMenu(){
		Inventory cosmetics = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "Cosmetics:");

		for(CosmeticItem i : CosmeticItem.values()){
			int slot = i.getSlot();
			ItemStack item = i.getItem();
			
			cosmetics.setItem(slot, item);
		}
		
		return cosmetics;
	}
	
	public static void openMenu(Player p){
		p.openInventory(getCosmeticMenu());
	}
}

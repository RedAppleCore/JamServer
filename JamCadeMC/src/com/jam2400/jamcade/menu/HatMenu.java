package com.jam2400.jamcade.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.jam2400.jamcade.items.HatItem;

public class HatMenu {
	public static Inventory getHatMenu(){
		Inventory hat = Bukkit.createInventory(null, 9, ChatColor.LIGHT_PURPLE + "Hats:");
		for(HatItem i : HatItem.values()){
			int slot = i.getSlot();
			ItemStack item = i.getItem();
			hat.setItem(slot, item);
		}
		return hat;
	}
	public static void openMenu(Player p){
		p.openInventory(getHatMenu());
	}
}

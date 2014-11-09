package com.jam2400.jamcade.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.jam2400.jamcade.items.ServerItem;

public class ServerMenu {
	public static Inventory getMenu(){
		Inventory menu = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Server Options:");
		for(ServerItem i : ServerItem.values()){
			int slot = i.getSlot();
			ItemStack item = i.getItem();
			menu.setItem(slot, item);
			
		}
		return menu;
	}
	public static void openMenu(Player p){
		p.openInventory(getMenu());
	}
}

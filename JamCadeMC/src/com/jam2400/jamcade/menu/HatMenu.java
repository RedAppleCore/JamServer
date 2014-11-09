package com.jam2400.jamcade.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.jam2400.jamcade.items.HatItem;

public class HatMenu {
	public static Inventory getHatMenu(){
		Inventory hat = Bukkit.createInventory(null, 9, ChatColor.LIGHT_PURPLE + "Hats:");
		hat.setItem(1, HatItem.tnt.getItem());
		hat.setItem(2, HatItem.melon.getItem());
		hat.setItem(3, HatItem.anvil.getItem());
		return hat;
	}
	public static void openMenu(Player p){
		p.openInventory(getHatMenu());
	}
}

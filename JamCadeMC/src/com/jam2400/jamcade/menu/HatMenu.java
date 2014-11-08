package com.jam2400.jamcade.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class HatMenu {
	public static Inventory getHatMenu(){
		Inventory hat = Bukkit.createInventory(null, 9, ChatColor.LIGHT_PURPLE + "Hats:");
		hat.setItem(1, Item.tnt.getItem());
		hat.setItem(2, Item.melon.getItem());
		hat.setItem(3, Item.anvil.getItem());
		hat.setItem(8, Item.back.getItem());
		return hat;
	}
	public static void openMenu(Player p){
		p.openInventory(getHatMenu());
	}
}

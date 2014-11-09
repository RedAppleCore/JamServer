package com.jam2400.jamcade.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ServerMenu {
	public static Inventory getMenu(){
		Inventory menu = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Server Options:");
		ItemStack enable = new ItemStack(Material.INK_SACK, 1, (short) 10);
		ItemMeta enableMeta = enable.getItemMeta();
		enableMeta.setDisplayName(ChatColor.GREEN + "Enable players");
		enable.setItemMeta(enableMeta);
		menu.setItem(1, enable);
		return menu;
	}
	public static void openMenu(Player p){
		p.openInventory(getMenu());
	}
}

package com.jam2400.jamcade;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CompassMenu {
	public static Inventory getMainMenu(){
		Inventory menu = Bukkit.createInventory(null, 9, ChatColor.RED + "Menu:");
		ItemStack wardrobe = new ItemStack(Material.IRON_CHESTPLATE);
		menu.setItem(0, wardrobe);
		return menu;
	}
	
	public static Inventory getWardrobeMenu(){
		Inventory wardrobe = Bukkit.createInventory(null, 40, ChatColor.GREEN + "Wardrobe:");
		ItemStack goldChestPlate = new ItemStack(Material.GOLD_CHESTPLATE);
		wardrobe.setItem(0, goldChestPlate);
		return wardrobe;
	}
	public static void openMenu(Player p){
		p.openInventory(getMainMenu());
	}
	
	public static void openWardrobe(Player p){
		
	}
}

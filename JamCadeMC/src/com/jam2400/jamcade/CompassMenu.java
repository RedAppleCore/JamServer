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
		// Initiate wardrobe and give name etc.
		Inventory wardrobe = Bukkit.createInventory(null, 45, ChatColor.GREEN + "Wardrobe:");
		
		// Define the items
		ItemStack goldChest = new ItemStack(Material.GOLD_CHESTPLATE);
		ItemStack ironChest = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack diamondChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
		
		// Set items in the wardrobe
		wardrobe.setItem(10, goldChest);
		wardrobe.setItem(11, ironChest);
		wardrobe.setItem(12, diamondChest);
		return wardrobe;
	}
	public static void openMenu(Player p){
		p.openInventory(getMainMenu());
	}
	
	public static void openWardrobe(Player p){
		p.openInventory(getWardrobeMenu());
	}
}

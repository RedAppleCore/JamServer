package com.jam2400.jamcade.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Item {
	// Wardrobe
	// Main Cosmetics Menu
	hats(ChatColor.GREEN + "Hats!", Material.PUMPKIN),
	wardrobe(ChatColor.DARK_RED + "Wardrobe!", Material.IRON_CHESTPLATE),
	back(ChatColor.BLUE + "Go back!", Material.ARROW);
	
	
	private final String displayName;
	private final Material material;
	
	Item(String displayName, Material material){
		this.displayName = displayName;
		this.material = material;
		
	}
	
	public String getDisplayName(){
		return displayName;
	}
	
	public Material getMaterial(){
		return material;
	}
	
	public ItemStack getItem(){
		ItemStack item = new ItemStack(getMaterial());
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(getDisplayName());
		item.setItemMeta(meta);
		
		return item;
	}
}
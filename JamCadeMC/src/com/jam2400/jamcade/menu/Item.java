package com.jam2400.jamcade.menu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Item {
	leatherChest(ChatColor.WHITE + "Leather Chestplate", Material.LEATHER_CHESTPLATE),
	goldChest(ChatColor.GOLD + "Golden Chestplate", Material.GOLD_CHESTPLATE),
	ironChest(ChatColor.GRAY + "Iron Chestplate", Material.IRON_CHESTPLATE),
	diamondChest(ChatColor.AQUA + "Diamond Chestplate", Material.DIAMOND_CHESTPLATE);
	
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

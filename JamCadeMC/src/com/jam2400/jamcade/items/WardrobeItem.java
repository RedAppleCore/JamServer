package com.jam2400.jamcade.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum WardrobeItem {
	//Hats
	leatherHat(ChatColor.WHITE + "Leather Helmet", Material.LEATHER_HELMET, 11),
	goldHat(ChatColor.GOLD + "Golden Helmet", Material.GOLD_HELMET, 12),
	ironHat(ChatColor.GRAY + "Iron Helmet", Material.IRON_HELMET, 13),
	diamondHat(ChatColor.AQUA + "Diamond Helmet", Material.DIAMOND_HELMET, 14),
	// Chests
	leatherChest(ChatColor.WHITE + "Leather Chestplate", Material.LEATHER_CHESTPLATE, 20),
	goldChest(ChatColor.GOLD + "Golden Chestplate", Material.GOLD_CHESTPLATE, 21),
	ironChest(ChatColor.GRAY + "Iron Chestplate", Material.IRON_CHESTPLATE, 22),
	diamondChest(ChatColor.AQUA + "Diamond Chestplate", Material.DIAMOND_CHESTPLATE, 23);
	// Leggings
	
	// Boots
	
	private final String displayName;
	private final Material material;
	private final int slot;
	
	WardrobeItem(String displayName, Material material, int slot){
		this.displayName = displayName;
		this.material = material;
		this.slot = slot;
		
	}
	
	public String getDisplayName(){
		return displayName;
	}
	
	public Material getMaterial(){
		return material;
	}
	
	public int getSlot(){
		return slot;
	}
	
	public ItemStack getItem(){
		ItemStack item = new ItemStack(getMaterial());
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(getDisplayName());
		item.setItemMeta(meta);
		
		return item;
	}
}


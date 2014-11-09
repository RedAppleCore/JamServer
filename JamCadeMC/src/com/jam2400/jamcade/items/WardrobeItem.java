package com.jam2400.jamcade.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum WardrobeItem {
	leatherChest(ChatColor.WHITE + "Leather Chestplate", Material.LEATHER_CHESTPLATE, 1),
	goldChest(ChatColor.GOLD + "Golden Chestplate", Material.GOLD_CHESTPLATE, 2),
	ironChest(ChatColor.GRAY + "Iron Chestplate", Material.IRON_CHESTPLATE, 3),
	diamondChest(ChatColor.AQUA + "Diamond Chestplate", Material.DIAMOND_CHESTPLATE, 4);
	
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


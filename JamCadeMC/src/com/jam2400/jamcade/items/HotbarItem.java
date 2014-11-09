package com.jam2400.jamcade.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum HotbarItem {
	
	menu(ChatColor.RED + "" + ChatColor.BOLD  + "Server Selector", Material.NETHER_STAR, 4),
	cosmetic(ChatColor.YELLOW + "" + ChatColor.BOLD + "Cosmetics", Material.PISTON_BASE, 1);
	private final String displayName;
	private final Material material;
	private final int slot;
	
	HotbarItem(String displayName, Material material, int slot){
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

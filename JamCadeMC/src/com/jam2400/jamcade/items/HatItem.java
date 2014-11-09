package com.jam2400.jamcade.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum HatItem {
	tnt(ChatColor.RED + "TNT!", Material.TNT, 1),
	melon(ChatColor.DARK_GREEN + "MELONE!", Material.MELON_BLOCK, 2),
	anvil(ChatColor.DARK_GRAY + "Anvil", Material.ANVIL, 3),
	wall(ChatColor.GRAY + "Cobblestone Wall", Material.COBBLE_WALL, 4),
	chest(ChatColor.GOLD + "Chest", Material.CHEST, 5);
	
	private final String displayName;
	private final Material material;
	private final int slot;
	
	HatItem(String displayName, Material material, int slot){
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

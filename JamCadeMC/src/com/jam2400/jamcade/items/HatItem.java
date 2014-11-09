package com.jam2400.jamcade.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum HatItem {
	tnt(ChatColor.RED + "TNT!", Material.TNT),
	melon(ChatColor.DARK_GREEN + "MELONE!", Material.MELON_BLOCK),
	anvil(ChatColor.DARK_GRAY + "Anvil", Material.ANVIL);
	
	private final String displayName;
	private final Material material;
	
	HatItem(String displayName, Material material){
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

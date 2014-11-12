package com.jam2400.jamcade.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum CosmeticItem {
	hats(ChatColor.GREEN + "Hats!", Material.PUMPKIN, 1),
	wardrobe(ChatColor.RED + "Wardrobe!", Material.IRON_CHESTPLATE, 2),
	particles(ChatColor.RED + "Particle Effects", Material.FIRE, 3);
	
	private final String displayName;
	private final Material material;
	private final int slot;
	
	CosmeticItem(String displayName, Material material, int slot){
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
		// Declare new ItemStack with material info
		ItemStack item = new ItemStack(getMaterial());
		// Declare meta
		ItemMeta meta = item.getItemMeta();
		// Set display name
		meta.setDisplayName(getDisplayName());
		// Set meta to item
		item.setItemMeta(meta);
		// Return the itemstack for use in inventories
		return item;
	}
}


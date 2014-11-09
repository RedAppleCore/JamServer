package com.jam2400.jamcade.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum ServerItem {
	
	on(ChatColor.GREEN + "Players on", Material.REDSTONE_TORCH_ON, 1, ChatColor.GRAY + "Turn ALL players on."),
	off(ChatColor.RED + "Players off", Material.REDSTONE_TORCH_OFF, 2, ChatColor.GRAY + "Turn ALL players off.");
	
	private final String displayName;
	private final Material material;
	private final int slot;
	private final String lore;
	
	ServerItem(String displayName, Material material, int slot, String lore){
		this.displayName = displayName;
		this.material = material;
		this.slot = slot;
		this.lore = lore;
		
	}
	
	public String getDisplayName(){
		return displayName;
	}
	
	public String getLore(){
		return lore;
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

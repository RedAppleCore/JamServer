package com.jam2400.jamcade.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import com.jam2400.jamcade.CompassMenu;
import com.jam2400.jamcade.Strings;
import com.jam2400.jamcade.utils.ChatUtils;
import com.jam2400.jamcade.utils.PlayerUtils;

public class MainListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		// Spawn location
		Location spawn = new Location(e.getPlayer().getWorld(), 5, 38, 1);
		
		// When the user logs in...
		Player p = e.getPlayer();
		p.sendMessage(Strings.tag + "Welcome!");
		
		// Join messages...
		e.setJoinMessage(null);
		ChatUtils.announce(PlayerUtils.getDisplayName(p) + ChatColor.RED +  " joined.");
		p.teleport(spawn);
		
		// Set gamemode accordingly...
		if (p.isOp()){
			p.setGameMode(GameMode.CREATIVE);
		} else {
			p.setGameMode(GameMode.ADVENTURE);
		}
		
		// Give items
		
		// Items (will eventually put in seperate class
		
		// WARDROBE!
		ItemStack wardrobe = new ItemStack(Material.IRON_CHESTPLATE);
		// Set information
		ItemMeta meta = wardrobe.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Wardrobe");
		// Assign information
		wardrobe.setItemMeta(meta);
		
		// Clear inventory and give items
		p.getInventory().clear();
		p.getInventory().setItem(1, wardrobe);
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		// Leave messages
		Player p = e.getPlayer();
		e.setQuitMessage(null);
		ChatUtils.announce(PlayerUtils.getDisplayName(p) + ChatColor.RED + " left.");
	}
	
	@EventHandler
	public void onBuild(BlockPlaceEvent e){
		Player p = e.getPlayer();
		
		if (PlayerUtils.canBuild(p) == false){
			e.setCancelled(true);
		} 
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		
		if (PlayerUtils.canBuild(p) == false){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked(); // Player who clicked
		ItemStack clicked = e.getCurrentItem(); // Item clicked
		Inventory inventory = e.getInventory(); // Inventory clicked
		if (inventory.getName().equals(CompassMenu.getMainMenu().getName())){
			// If the inventory clicked was the main compass menu
			if (clicked.getType() == Material.IRON_CHESTPLATE){
				Inventory wardrobe = CompassMenu.getWardrobeMenu();
				p.openInventory(wardrobe);
				e.setCancelled(true); // Make sure chestplate stays
				p.closeInventory();
			}
		}
		
		if (inventory.getName().equals(CompassMenu.getWardrobeMenu().getName())){
			p.getInventory().setChestplate(clicked);
			e.setCancelled(true);
		}
		
			
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		// If it was right clicked, in air, or on a block and is an iron chestplate...open the menu!
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().getType() == Material.IRON_CHESTPLATE){
			CompassMenu.openWardrobe(p);
		}
	}
	
}

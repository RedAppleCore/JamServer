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


import com.jam2400.jamcade.CompassMenu;
import com.jam2400.jamcade.Strings;
import com.jam2400.jamcade.utils.ChatUtils;
import com.jam2400.jamcade.utils.PlayerUtils;

public class MainListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Location spawn = new Location(e.getPlayer().getWorld(), 5, 38, 1);
		
		// When the user logs in...
		Player p = e.getPlayer();
		p.sendMessage(Strings.tag + "Welcome!");
		
		e.setJoinMessage(null);
		ChatUtils.announce(PlayerUtils.getDisplayName(p) + ChatColor.RED +  " joined.");
		p.teleport(spawn);
		
		if (p.isOp()){
			p.setGameMode(GameMode.CREATIVE);
		} else {
			p.setGameMode(GameMode.ADVENTURE);
		}
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e){
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
			// If the inventory clicked was the compass menu
			if (clicked.getType() == Material.IRON_CHESTPLATE){
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			CompassMenu.openMenu(p);
		}
	}
	
}

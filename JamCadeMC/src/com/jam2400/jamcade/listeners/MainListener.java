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
import com.jam2400.jamcade.api.ChatUtils;
import com.jam2400.jamcade.api.PlayerUtils;
import com.jam2400.jamcade.items.Menu;
import com.jam2400.jamcade.items.Wardrobe;
import com.jam2400.jamcade.menu.CompassMenu;

public class MainListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		// Spawn location
		Location spawn = new Location(e.getPlayer().getWorld(), 5, 38, 1);
		
		// When the user logs in...
		Player p = e.getPlayer();
		
		// Join messages...
		e.setJoinMessage(null);
		ChatUtils.announce(PlayerUtils.getDisplayName(p) + ChatColor.RED +  " joined.");
		p.teleport(spawn);
		
		// Set gamemode accordingly...
		if (PlayerUtils.isOwner(p)){
			p.setGameMode(GameMode.CREATIVE);
		} else {
			p.setGameMode(GameMode.ADVENTURE);
		}
		
		// Clear inventory and give items
		p.getInventory().clear();
		
		if (PlayerUtils.hasWardrobe(p)){
			// Only if they can use the wardrobe shall we give them the item...
			p.getInventory().setItem(1, Wardrobe.getItem());
		}
		p.getInventory().setItem(4, Menu.getItem());
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
	
}

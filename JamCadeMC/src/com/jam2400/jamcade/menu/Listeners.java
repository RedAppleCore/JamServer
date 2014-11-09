package com.jam2400.jamcade.menu;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.jam2400.jamcade.Strings;
import com.jam2400.jamcade.api.PlayerUtils;

public class Listeners implements Listener{
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked(); // Player who clicked
		ItemStack clicked = e.getCurrentItem(); // Item clicked
		Inventory inventory = e.getInventory(); // Inventory clicked
		
		
		if (inventory.getName().equals(CosmeticMenu.getCosmeticMenu().getName())){
			if (clicked.getType() == Material.PUMPKIN){
				HatMenu.openMenu(p);
				e.setCancelled(true);
			} else if (clicked.getType() == Material.IRON_CHESTPLATE){
				WardrobeMenu.openWardrobe(p);
				e.setCancelled(true);
			}
		}
		else if (inventory.getName().equals(WardrobeMenu.getWardrobeMenu().getName())){
			p.getInventory().setChestplate(clicked);
			e.setCancelled(true);
			p.closeInventory();
		}
		else if (inventory.getName().equals(HatMenu.getHatMenu().getName())){
			if (clicked.getType() == Material.ARROW){
				CosmeticMenu.openMenu(p);
			} else {
			p.getInventory().setHelmet(clicked);
			e.setCancelled(true);
			p.closeInventory();
			}
		}
	}
			
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		// If it was right clicked, in air, or on a block and is an iron chestplate...open the menu!
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
			if(p.getItemInHand().getType() == Material.IRON_CHESTPLATE){
				WardrobeMenu.openWardrobe(p);
			} else if(p.getItemInHand().getType() == Material.PISTON_BASE){
				if (PlayerUtils.hasWardrobe(p)){
				CosmeticMenu.openMenu(p);
				} else {
					p.sendMessage(Strings.error("Only members and up can use cosmetics."));
				}
			} else if(p.getItemInHand().getType() == Material.NETHER_STAR){
				ServerMenu.openMenu(p);
			}
	}
}

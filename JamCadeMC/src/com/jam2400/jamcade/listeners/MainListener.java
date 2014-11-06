package com.jam2400.jamcade.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


import com.jam2400.jamcade.Strings;
import com.jam2400.jamcade.ranks.Rank;
import com.jam2400.jamcade.utils.ChatUtils;
import com.jam2400.jamcade.utils.PlayerUtils;

public class MainListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		// When the user logs in...
		Player p = e.getPlayer();
		p.sendMessage(Strings.tag + "Welcome!");
		
		e.setJoinMessage(null);
		ChatUtils.announce(PlayerUtils.getDisplayName(p) + ChatColor.RED +  " joined.");
		
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
	
	
}

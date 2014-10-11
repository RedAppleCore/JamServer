package com.jam2400.jamcade.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.jam2400.jamcade.Main;
import com.jam2400.jamcade.Strings;

public class MainListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		// When the user logs in...
		Player p = e.getPlayer();
		String name = p.getName();
		p.sendMessage(Strings.tag + "Welcome!");
		
		e.setJoinMessage(null);
		Main.announce(name + " has joined the server.");
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		Player p = e.getPlayer();
		String name = p.getName();
		e.setQuitMessage(null);
		Main.announce(name + " has left the server.");
	}
}

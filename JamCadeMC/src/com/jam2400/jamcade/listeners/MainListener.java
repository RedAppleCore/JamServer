package com.jam2400.jamcade.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.jam2400.jamcade.Strings;

public class MainListener implements Listener {
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e){
		// When the user logs in...
		Player p = e.getPlayer();
		p.sendMessage(Strings.tag + "Welcome!");
	}
}

package com.jam2400.jamcade.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import com.jam2400.jamcade.api.Status;

public class MainListener implements Listener {
	@EventHandler
	public void onServerListPing(ServerListPingEvent e){
		String motd = ChatColor.RED + "JamCade.co.uk" + ChatColor.GRAY + " | " + ChatColor.GREEN 
				+ "In Development\n" + ChatColor.AQUA + "" + ChatColor.BOLD +  "New wardrobes!";
		e.setMotd(motd);
	}
}

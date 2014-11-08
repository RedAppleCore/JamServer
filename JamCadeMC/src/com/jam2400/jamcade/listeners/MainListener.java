package com.jam2400.jamcade.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import com.jam2400.jamcade.api.Status;

public class MainListener implements Listener {
	@EventHandler
	public void onServerListPing(ServerListPingEvent e){
		e.setMotd(Status.getMotd());
	}
}

package com.jam2400.jamcade.listeners;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


import com.jam2400.jamcade.Strings;
import com.jam2400.jamcade.api.PlayerUtils;
import com.jam2400.jamcade.ranks.Rank;

public class ChatListener implements Listener{
	
	@EventHandler
	public void PlayerChatEvent(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		ChatColor color = Rank.getRank(p).getColor();
		ChatColor msgColor = Rank.getRank(p).getMsgColor();
		String name = p.getName();
		String msg = e.getMessage();
		
		if (PlayerUtils.canChat(p) == false){
			e.setCancelled(true);
			p.sendMessage(Strings.error("You cannot chat at this time."));
		}
		
		e.setFormat(color + name + " > " + msgColor + msg);
		
	}
}

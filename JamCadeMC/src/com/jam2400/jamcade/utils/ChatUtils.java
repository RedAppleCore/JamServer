package com.jam2400.jamcade.utils;

import static com.jam2400.jamcade.Strings.tag;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.jam2400.jamcade.Main;


public class ChatUtils {
	private final Main plugin;
	public ChatUtils(Main s){
		this.plugin = s;
	}
	// prints chat and stuff
	public static void announce(String message){
		Bukkit.broadcastMessage(tag + message);
	}
	public static void GlobalMsg(String message){
		for (Player p : Bukkit.getServer().getOnlinePlayers()){
			p.sendMessage(message);
		}
	}
}

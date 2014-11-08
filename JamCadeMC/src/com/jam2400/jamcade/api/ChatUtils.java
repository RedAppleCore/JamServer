package com.jam2400.jamcade.utils;

import static com.jam2400.jamcade.Strings.tag;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.jam2400.jamcade.Main;
import com.jam2400.jamcade.Strings;


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
	public static void staffMsg(String msg, Player sender){
		for (Player p : MainUtils.getStaffChatMembers()){
			String name = PlayerUtils.getDisplayName(sender);
			String finalMsg = Strings.staff + name + " > " + msg;
			p.sendMessage(finalMsg);
			Bukkit.getServer().getLogger().info(finalMsg);
		}
	}
}

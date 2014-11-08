package com.jam2400.jamcade.api;

import org.bukkit.ChatColor;

public class Status {
	
	public static String motd = ChatColor.RED + "JamCade.co.uk" + ChatColor.GRAY + " | " + ChatColor.GREEN 
			+ "In Development\n" + ChatColor.AQUA + "" + ChatColor.BOLD +  "New wardrobes!";
	
	public static String getMotd(){
		return motd;
	}
}

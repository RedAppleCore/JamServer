package com.jam2400.jamcade;

import static org.bukkit.ChatColor.*;

public class Strings  {
	
	@SuppressWarnings("unused")
	private final Main plugin;
	public Strings(Main s)
	{
		this.plugin = s;
	}
	
	public static final String tag = (GRAY + "[" + RED + "JamCade" + GRAY + "] ");
	
	public static final String error = (GRAY + "[" + RED + BOLD + "X" + RESET + GRAY + "] " + RED);
	
	public static final String success = (GRAY + "[" + GREEN + BOLD + "O" + RESET + GRAY + "] ");
	
	public static final String playerOnly = ("Only a player can perform this command. Dum Dum");
	
	public static final String welcome = (tag + "Welcome to JamCade");
	
	public static String error (String message){
		String response = error + message;
		return response;
	}
	public static String success (String message){
		String response = error + success;
		return response;
	}

}

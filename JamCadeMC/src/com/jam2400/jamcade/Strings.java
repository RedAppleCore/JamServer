package com.jam2400.jamcade;

import static org.bukkit.ChatColor.*;

public class Strings  {
	
	@SuppressWarnings("unused")
	private final Main plugin;
	public Strings(Main s)
	{
		this.plugin = s;
	}
	
	public static final String TAG = (GRAY + "[" + RED + "JamCade" + GRAY + "] ");
	
	public static final String ERROR = (GRAY + "[" + RED + BOLD + "X" + RESET + GRAY + "] " + RED);
	
	public static final String SUCCESS = (GRAY + "[" + GREEN + BOLD + "O" + RESET + GRAY + "] ");
	
	public static final String PLAYER_ONLY = ("Only a player can perform this command. Dum Dum");
	
	public static final String WELCOME = (TAG + "Welcome to JamCade");
	
	public static final String STAFF = (TAG + GRAY + "[" + YELLOW + "Staff" + GRAY + "] " + GREEN);
	
	public static String error (String message){
		String response = ERROR + message;
		return response;
	}
	public static String success (String message){
		String response = SUCCESS + message;
		return response;
	}

}

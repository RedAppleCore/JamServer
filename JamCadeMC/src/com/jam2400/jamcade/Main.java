package com.jam2400.jamcade;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable(){
		getLogger().info("JamCade is intiated!");
	}
	
	@Override
	public void onDisable(){
		getLogger().info("JamCade disabled.");
	}
	
	public boolean onCommmand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.equals("hi")){
			Player player = (Player) sender;
			player.sendMessage(ChatColor.GOLD + "Hi");
			
			
		}
		
		return false;
	}

}



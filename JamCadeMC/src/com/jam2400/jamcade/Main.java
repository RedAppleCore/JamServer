package com.jam2400.jamcade;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.jam2400.jamcade.listeners.MainListener;
import static com.jam2400.jamcade.Strings.*;

public class Main extends JavaPlugin implements Listener {
	
public static Main plugin;
	@Override
	public void onEnable(){
		getLogger().info("JamCade is intiated!");
	}
	
	@Override
	public void onDisable(){
		getLogger().info("JamCade disabled.");
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("heal")) { // If the player typed /basic then do the following...
			if(args.length == 0){
				// No player specified. Let's heal the sender!
				// Wait! What if the console sent this...? Can't do that nooooo...
				if(!(sender instanceof Player)){
					sender.sendMessage(playerOnly);
				} else {
					Player p = (Player) sender;
					p.setHealth(20);
					p.setFoodLevel(20);
					p.sendMessage(success + "Healed you!");
				}
			} else if(args.length == 1){
				// AHA! A player was specified. Let's heal them!
				// The console can do this anyway. It's not healing themselves
				Player target = Bukkit.getPlayer(args[0]);
				Player p = (Player) sender;
				if(target == null){
				// This means the target is invalid, or not online.
				p.sendMessage(error + "This target is either online, or invalid.");
				} else {
					p.sendMessage(success + "Healed the player!");
					target.setHealth(20);
					target.setFoodLevel(20);
					String healer = p.getName();
					target.sendMessage(tag + "You were healed by " + ChatColor.GREEN 
							+ healer + ChatColor.GRAY 
							+ ", be sure to thank them!");
				}
			}
			
			return true; //If this has happened the function will return true. 
	        // If this hasn't happened the value of false will be returned.
		}

		return false; 
	}
}

	



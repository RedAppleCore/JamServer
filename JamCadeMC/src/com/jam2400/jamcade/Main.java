package com.jam2400.jamcade;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



import com.jam2400.jamcade.api.ChatUtils;
import com.jam2400.jamcade.api.MainUtils;
import com.jam2400.jamcade.api.PlayerUtils;
import com.jam2400.jamcade.listeners.ChatListener;
import com.jam2400.jamcade.listeners.MainListener;
import com.jam2400.jamcade.listeners.PlayerListener;
import com.jam2400.jamcade.menu.Listeners;

import static com.jam2400.jamcade.Strings.*;

public class Main extends JavaPlugin {
	
public static Main plugin;
	@Override
	public void onEnable(){
		getLogger().info(success + "JamCade is intiated!");
		plugin = this;
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new PlayerListener(), this);
		pm.registerEvents(new ChatListener(), this);
		pm.registerEvents(new Listeners(), this);
		pm.registerEvents(new MainListener(), this);
	}
	
	@Override
	public void onDisable(){
		getLogger().info("JamCade disabled.");
		plugin = null;
	}
	public static Plugin getPlugin(){
		return plugin;
	}
	
	// Commands
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
					heal(p);
					p.sendMessage(success("Healed you!"));
				}
			} else if(args.length == 1){
				// AHA! A player was specified. Let's heal them!
				// The console can do this anyway. It's not healing themselves
				Player target = Bukkit.getPlayer(args[0]);
				Player p = (Player) sender;
				if(target == null){
				// This means the target is invalid, or not online.
				p.sendMessage(error("This target is either offline, or invalid."));
				} else {
					p.sendMessage(success("Healed the player!"));
					heal(target);
					String healer = p.getName();
					target.sendMessage(tag + "You were healed by " + ChatColor.GREEN 
							+ healer + ChatColor.GRAY 
							+ ", be sure to thank them!");
				}
			}
			
			return true; 
		}
		else if (cmd.getName().equalsIgnoreCase("announce")){
			Player p = (Player) sender;
			if(args.length == 0){ // If no message specified
				p.sendMessage(error("Specify a message to announce."));
			} else { // if there are the right amount of arguments use string builder to collect all args to make one string
				StringBuilder message = new StringBuilder("");
			    for (String part : args) {
			        if (!message.toString().equals(""))
			            message.append(" ");
			 
			        message.append(part);
			    }
			    ChatUtils.announce(message.toString()); // finally call announce method
			}
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase("warn")){
			Player p = (Player) sender;
			if(args.length == 0){ // if no player
				p.sendMessage(error("You have to specify a player to send."));
			} else if(args.length == 1) { // if no reason
				p.sendMessage(error("Give a reason..."));
			}
			else if (args.length == 2){ // if the right amount of arguments 
				if(Bukkit.getPlayer(args[0]) == null){ // non existent player, or offline
					p.sendMessage(error("There has been an error, or this player is offline."));
				} else {
					Player target = Bukkit.getPlayer(args[0]);
					warn(target, args[1]); // finally call the 'warn' method
				}
			}
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase("kick")){
			Player p = (Player) sender;
			if(args.length == 0){ // if no player specified
				p.sendMessage(error("You have to specify a player to send."));
			} else if(args.length == 1){ // if no reason
				p.sendMessage(error("Give a reason..."));
			} else { // if right amount of arguments
				Player target = Bukkit.getPlayer(args[0]);
				kick(target, args[1], sender); // call 'kick' method
			}
		}
		else if (cmd.getName().equalsIgnoreCase("m")) {
			Player player = (Player) sender;
			if(args.length < 1) { // if no player specified
				player.sendMessage(error("You need to specify a player."));
			}
			else if(args.length < 2) { // if no message
				player.sendMessage(error("You need a message to send to " + args[0]));
			}
			else { // if right amount of args
				Player target = Bukkit.getPlayer(args[0]);
				if (target != null && target.isOnline() == true) { // checks if player is valid
					StringBuilder sb = new StringBuilder(""); // use string builder
					boolean first = true;
					for(int i = 1; i<args.length;i++){ // for every argument
						if(!first){
							sb.append(" ");
						}
						else {
							first = false;
						}
						sb.append(args[i]);
					}
				target.sendMessage(ChatColor.DARK_GRAY + "[" + sender.getName() + " says] " + ChatColor.GREEN + sb.toString());
				}
				else {
				player.sendMessage(error("This player is not online!"));// player not online, send error
				}
			}
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase("staff")){
			if (MainUtils.getOnlineStaff().size() == 0){ // If no staff
				sender.sendMessage(error("There are no staff currently online."));
			} else { // If there are staff
			sender.sendMessage(ChatColor.GRAY + "The following staff are online.");
			for (Player p : MainUtils.getOnlineStaff()){ // print them out on each line
				sender.sendMessage(" - " + PlayerUtils.getDisplayName(p));
			}
			}
			
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase("horsify")){
			Player p = (Player) sender;
			Location loc = p.getLocation();
			Horse horse = (Horse) loc.getWorld().spawnEntity(loc, EntityType.HORSE);
			horse.setTamed(true);
			horse.setOwner(p);
			horse.setVariant(Variant.UNDEAD_HORSE);
			horse.setPassenger(p);
			
			return true;
		}
		return false; 
	}
	public static void warn(Player p, String reason){
		p.sendMessage(tag + "You were warned for '" + ChatColor.GOLD + reason + ChatColor.GRAY + "' - continuing will result in a ban!");
	}
	public static void heal(Player p){
		p.setHealth(20D);
		p.setFoodLevel(20);
	}
	
	public static void kick(Player p, String reason, CommandSender sender){
		p.kickPlayer("Kicked for " + reason);
		ChatUtils.staffMsg(p + "was kicked from the server for " + reason, (Player) sender);
	}

}

	



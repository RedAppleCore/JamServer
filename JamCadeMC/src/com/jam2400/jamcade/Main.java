package com.jam2400.jamcade;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import static com.jam2400.jamcade.Strings.*;

public class Main extends JavaPlugin implements Listener {
	
public static Main plugin;
	@Override
	public void onEnable(){
		getLogger().info(success + "JamCade is intiated!");
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(this, this);
	}
	
	@Override
	public void onDisable(){
		getLogger().info("JamCade disabled.");
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
					p.sendMessage(success + "Healed you!");
				}
			} else if(args.length == 1){
				// AHA! A player was specified. Let's heal them!
				// The console can do this anyway. It's not healing themselves
				Player target = Bukkit.getPlayer(args[0]);
				Player p = (Player) sender;
				if(target == null){
				// This means the target is invalid, or not online.
				p.sendMessage(error + "This target is either offline, or invalid.");
				} else {
					p.sendMessage(success + "Healed the player!");
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
			if(args.length == 0){
				p.sendMessage(error + "Specify a message to announce.");
			} else if (args.length < 1){
				return false;
			} else {
				StringBuilder message = new StringBuilder("");
			    for (String part : args) {
			        if (!message.toString().equals(""))
			            message.append(" ");
			 
			        message.append(part);
			    }
			    announce(message.toString());
			}
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase("warn")){
			Player p = (Player) sender;
			if(args.length == 0){
				// this means no player has been specified...
				p.sendMessage(error + "You have to specify a player to send.");
			} else if(args.length == 1) {
				p.sendMessage(error + "Give a reason...");
			}
			else if (args.length == 2){
				if(Bukkit.getPlayer(args[0]) == null){
					p.sendMessage(error + "There has been an error, or this player is offline.");
				} else {
					Player target = Bukkit.getPlayer(args[0]);
					warn(target, args[1]);
				}
			}
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase("kick")){
			Player p = (Player) sender;
			if(args.length == 0){
				p.sendMessage(error + "You have to specify a player to send.");
			} else if(args.length == 1){
				p.sendMessage(error + "Give a reason...");
			} else {
				Player target = Bukkit.getPlayer(args[0]);
				kick(target, args[1]);
			}
		}
		else if (cmd.getName().equalsIgnoreCase("m")) {
			Player player = (Player) sender;
			if(args.length < 1) {
				player.sendMessage(error + "You need to specify a player.");
			}
			else if(args.length < 2) {
				player.sendMessage(error + "You need a message to send to " + args[0]);
			}
			else {
				Player target = Bukkit.getPlayer(args[0]);
				
				if (target != null && target.isOnline() == true) {
					StringBuilder sb = new StringBuilder("");
					boolean first = true;
					for(int i = 1; i<args.length;i++){
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
				player.sendMessage(error + "This player is not online!");	
				}
			}
		}
		return false; 
	}
	
	public void announce(String message){
		Bukkit.broadcastMessage(tag + message);
	}
	public void warn(Player p, String reason){
		p.sendMessage(tag + "You were warned for '" + ChatColor.GOLD + reason + ChatColor.GRAY + "' - continuing will result in a ban!");
	}
	public void heal(Player p){
		p.setHealth(20D);
		p.setFoodLevel(20);
	}
	
	public void kick(Player p, String reason){
		p.kickPlayer("Kicked for " + reason);
		announce(p + "was kicked from the server for " + reason);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		p.sendMessage(welcome);
	}
	
	
}

	



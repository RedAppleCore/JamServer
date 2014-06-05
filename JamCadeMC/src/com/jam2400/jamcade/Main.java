package com.jam2400.jamcade;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable(){
		getLogger().info("JamCade is intiated!");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable(){
		getLogger().info("JamCade disabled.");
	}
	
	public boolean onCommmand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("hi")){
			Player player = (Player) sender;
			player.sendMessage(ChatColor.GOLD + "Hi");
			return true;
		}
		
		return false;
	}
	
	@EventHandler
	public void playerMove(PlayerMoveEvent event){
	Player p = event.getPlayer();
	Block block = event.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN);
	Material m = block.getType();
	if(!(m == Material.GRASS)){
		if(!(p.isFlying() == true)){
		block.setType(Material.STONE);	
	}
	
	}
	
	}

}



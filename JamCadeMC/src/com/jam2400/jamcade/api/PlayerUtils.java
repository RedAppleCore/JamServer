package com.jam2400.jamcade.api;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.jam2400.jamcade.ranks.Rank;

public class PlayerUtils {
	public static String getDisplayName(Player p){
	    ChatColor color = Rank.getRank(p).getColor();
	    String name = p.getName();
	    String displayName = color + name;
	    return displayName;
	}
	public static boolean canBuild(Player p){
		if (p.hasPermission("jamcade.build")){return true;}
		else {return false;}
	}
	public static boolean canChat(Player p){
		if (p.hasPermission("jamcade.chat")){return true;}
		else {return false;}
	}
	public static boolean hasWardrobe(Player p){
		if (p.hasPermission("jamcade.wardrobe")){return true;}
		else {return false;}
	}
	public static boolean isOwner(Player p){
		if (p.hasPermission("jamcade.owner")){return true;}
		else {return false;}
	}
}

package com.jam2400.jamcade.utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.jam2400.jamcade.Strings;
import com.jam2400.jamcade.ranks.Rank;

public class MainUtils {
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
	
	public static ArrayList<Player> getOnlineStaff(){
		ArrayList<Player> staff = new ArrayList<Player>();
		for (Player p : Bukkit.getOnlinePlayers()){
			if (p.hasPermission("jamcade.admin")){
				staff.add(p);
			}
		}
		return staff;
	}
}

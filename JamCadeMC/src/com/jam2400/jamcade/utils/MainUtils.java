package com.jam2400.jamcade.utils;

import org.bukkit.entity.Player;

public class MainUtils {
	public static boolean canBuild(Player p){
		if (p.hasPermission("jamcade.build")){return true;}
		else {return false;}
	}
	public static boolean canChat(Player p){
		if (p.hasPermission("jamcade.chat")){return true;}
		else {return false;}
	}
}

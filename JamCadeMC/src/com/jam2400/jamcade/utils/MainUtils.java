package com.jam2400.jamcade.utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MainUtils {
	
	public static ArrayList<Player> getOnlineStaff(){
		ArrayList<Player> staff = new ArrayList<Player>();
		for (Player p : Bukkit.getOnlinePlayers()){
			if (p.hasPermission("jamcade.admin")){
				staff.add(p);
			}
		}
		return staff;
	}
	
	public static ArrayList<Player> getStaffChatMembers(){
		ArrayList<Player> staffchatmembers = new ArrayList<Player>();
		return staffchatmembers;
	}
}

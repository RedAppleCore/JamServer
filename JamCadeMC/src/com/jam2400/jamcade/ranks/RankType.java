package com.jam2400.jamcade.ranks;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class RankType {
	
	public enum Rank {
		owner(ChatColor.YELLOW, "jamcade.owner"),
		admin(ChatColor.RED, "jamcade.admin"),
		member(ChatColor.GREEN, "jamcade.member"),
		guest(ChatColor.GRAY, "jamcade.guest");
		
		private final ChatColor color;
		private final String node;
		
		Rank(ChatColor color, String node){
			this.color = color;
			this.node = node;
		}
		
		public ChatColor getColor() {
			return color;
		}
		
		public String getNode() {
			return node;
		}
		
		public static Rank getRank(Player p) {
			if(p.hasPermission("jamcade.owner")) {
				return Rank.owner;
			}
			else if (p.hasPermission("jamcade.admin")) {
				return Rank.admin;
			}
			else if (p.hasPermission("jamcade.member")) {
				return Rank.member;
			} else {
				return Rank.guest;
			}
		}
	}

}

package com.jam2400.jamcade.ranks;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

	public enum Rank {
		owner(ChatColor.YELLOW, "jamcade.owner", ChatColor.GREEN),
		admin(ChatColor.RED, "jamcade.admin", ChatColor.WHITE),
		member(ChatColor.GREEN, "jamcade.member", ChatColor.WHITE),
		guest(ChatColor.GRAY, "jamcade.guest", ChatColor.GRAY);
		
		private final ChatColor color;
		private final String node;
		private final ChatColor msgcolor;
		
		Rank(ChatColor color, String node, ChatColor msgcolor){
			this.color = color;
			this.node = node;
			this.msgcolor = msgcolor;
		}
		
		public ChatColor getColor() {
			return color;
		}
		
		public String getNode() {
			return node;
		}
		public ChatColor getMsgColor(){
			return msgcolor;
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

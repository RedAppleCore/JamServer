package com.jam2400.jamcade.ranks;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

	public enum Rank {
		owner(ChatColor.YELLOW, "jamcade.owner", ChatColor.GREEN),
		admin(ChatColor.RED, "jamcade.admin", ChatColor.WHITE),
		member(ChatColor.DARK_GREEN, "jamcade.member", ChatColor.WHITE),
		regular(ChatColor.GRAY, "jamcade.regular", ChatColor.GRAY);
		
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
			if(p.hasPermission(Rank.owner.getNode())) {
				return Rank.owner;
			}
			else if (p.hasPermission(Rank.admin.getNode())) {
				return Rank.admin;
			}
			else if (p.hasPermission(Rank.member.getNode())) {
				return Rank.member;
			} else {
				return Rank.regular;
			}
		}
	}

package com.jam2400.jamcade;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable(){
		getLogger().info("JamCade is intiated!");
	}
	
	@Override
	public void onDisable(){
		getLogger().info("JamCade disabled.");
	}

}

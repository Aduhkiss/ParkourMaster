package me.atticusthecoder.parkour;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.atticusthecoder.parkour.commands.ParkourCommand;
import me.atticusthecoder.parkour.corelistener.AntiCheat;
import me.atticusthecoder.parkour.corelistener.PlayerInteractions;
import me.atticusthecoder.parkour.mylisteners.ParkourListeners;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		getConfig().options().copyDefaults(true);
		getConfig().options().copyHeader(true);
		saveDefaultConfig();
		
		// Register our handlers
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new AntiCheat(), this);
		pm.registerEvents(new PlayerInteractions(), this);
		
		pm.registerEvents(new ParkourListeners(), this);
		
		// Register our commands
		getCommand("parkour").setExecutor(new ParkourCommand());
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static Main getPlugin() {
		return plugin;
	}

}

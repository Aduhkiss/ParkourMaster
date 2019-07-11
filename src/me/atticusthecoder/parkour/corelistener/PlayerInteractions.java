package me.atticusthecoder.parkour.corelistener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.atticusthecoder.parkour.Main;
import me.atticusthecoder.parkour.event.ParkourCompleteEvent;
import me.atticusthecoder.parkour.event.ParkourStartEvent;

public class PlayerInteractions implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getAction() == Action.PHYSICAL) {
			// Grab the item
			Block block = e.getClickedBlock();
			
			// If this event happened in the parkour world, then we want to keep going
			// otherwise frick off
			if(block.getWorld().getName().equalsIgnoreCase(Main.getPlugin().getConfig().getString("parkourWorld"))) {
				
				
				if(block.getType() == Material.GOLD_PLATE) {
					// Start the parkour
					Main.getPlugin().getServer().getPluginManager().callEvent(new ParkourStartEvent(e.getPlayer()));
				}
				
				if(block.getType() == Material.IRON_PLATE) {
					// End the parkour
					Main.getPlugin().getServer().getPluginManager().callEvent(new ParkourCompleteEvent(e.getPlayer()));
				}
			}
		}
	}

}

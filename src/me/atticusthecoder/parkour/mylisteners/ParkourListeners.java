package me.atticusthecoder.parkour.mylisteners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.atticusthecoder.parkour.common.FailCause;
import me.atticusthecoder.parkour.common.ParkourData;
import me.atticusthecoder.parkour.event.ParkourCompleteEvent;
import me.atticusthecoder.parkour.event.ParkourFailEvent;
import me.atticusthecoder.parkour.event.ParkourStartEvent;
import me.atticusthecoder.parkour.manager.ParkourManager;
import me.atticusthecoder.parkour.util.TimeUtil;
import net.md_5.bungee.api.ChatColor;

public class ParkourListeners implements Listener {
	
	@EventHandler
	public void onParkourStart(ParkourStartEvent e) {
		if(!ParkourManager.get().isDoingParkour(e.getPlayer())) {
			e.getPlayer().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "You started the parkour!");
			ParkourManager.get().addToParkour(e.getPlayer());
			
			// Add their data
			ParkourManager.get().createParkourData(e.getPlayer(), new ParkourData(e.getPlayer(), System.currentTimeMillis()));
		}
	}
	
	@EventHandler
	public void onComplete(ParkourCompleteEvent e) {
		ParkourData data = ParkourManager.get().getParkourData(e.getPlayer());
		
		data.setEndTime(System.currentTimeMillis());
		
		e.getPlayer().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Congrats! You finished the parkour in " + TimeUtil.milliToNormal(data.getRunLength()) + "!");
		ParkourManager.get().removeFromParkour(e.getPlayer());
	}
	
	@EventHandler
	public void onFail(ParkourFailEvent e) {
		if(e.getCause() == FailCause.STARTED_FLYING) {
			e.getPlayer().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Oh no! You failed the parkour because you started flying!");
		}
		if(e.getCause() == FailCause.TELEPORTED) {
			e.getPlayer().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Oh no! You failed the parkour because you teleported!");
		}
		ParkourManager.get().removeFromParkour(e.getPlayer());
		return;
	}

}

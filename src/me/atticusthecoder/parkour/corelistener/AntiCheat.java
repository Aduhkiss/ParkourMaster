package me.atticusthecoder.parkour.corelistener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

import me.atticusthecoder.parkour.Main;
import me.atticusthecoder.parkour.common.FailCause;
import me.atticusthecoder.parkour.event.ParkourFailEvent;
import me.atticusthecoder.parkour.manager.ParkourManager;

public class AntiCheat implements Listener {
	
	@EventHandler
	public void onPlayerStartFlying(PlayerToggleFlightEvent e) {
		if(ParkourManager.get().isDoingParkour(e.getPlayer())) {
			Main.getPlugin().getServer().getPluginManager().callEvent(new ParkourFailEvent(e.getPlayer(), FailCause.STARTED_FLYING));
			return;
		}
	}
	
	@EventHandler
	public void onTeleport(PlayerTeleportEvent e) {
		if(ParkourManager.get().isDoingParkour(e.getPlayer())) {
			Main.getPlugin().getServer().getPluginManager().callEvent(new ParkourFailEvent(e.getPlayer(), FailCause.TELEPORTED));
			return;
		}
	}

}

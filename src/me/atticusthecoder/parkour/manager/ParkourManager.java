package me.atticusthecoder.parkour.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;

import me.atticusthecoder.parkour.common.ParkourData;

public class ParkourManager {
	public static ParkourManager me;
	
	public static ParkourManager get() {
		if(me == null) {
			me = new ParkourManager();
		}
		return me;
	}
	
	private List<Player> inParkour = new ArrayList<Player>();
	private Map<Player, ParkourData> parkourData = new HashMap<Player, ParkourData>();
	
	public boolean isDoingParkour(Player player) {
		for(Player pl : inParkour) {
			if(pl.getName().equalsIgnoreCase(player.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public void addToParkour(Player player) {
		inParkour.add(player);
	}
	
	public void removeFromParkour(Player player) {
		inParkour.remove(player);
	}
	
	// Parkour data things
	public ParkourData getParkourData(Player player) {
		return parkourData.get(player);
	}
	
	public void createParkourData(Player player, ParkourData data) {
		parkourData.put(player, data);
	}
	
	public void deleteParkourData(Player player) {
		parkourData.remove(player);
	}
}

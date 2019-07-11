package me.atticusthecoder.parkour.common;

import org.bukkit.entity.Player;

public class ParkourData {
	
	private Player player;
	private long startTime;
	private long endTime;
	
	public ParkourData(Player player, long startTime) {
		this.player = player;
		this.startTime = startTime;
	}
	
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	
	public long getRunLength() {
		return endTime - startTime;
	}
	
	public Player getPlayer() {
		return player;
	}
}

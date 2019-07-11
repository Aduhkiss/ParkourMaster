package me.atticusthecoder.parkour.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.atticusthecoder.parkour.common.FailCause;

public class ParkourFailEvent extends Event {
	
	private static final HandlerList handlers = new HandlerList();
	private Player player;
	private FailCause failCause;
	
	public ParkourFailEvent(Player player, FailCause cause) {
		this.player = player;
		this.failCause = cause;
	}

	@Override
    public HandlerList getHandlers() 
    {
        return handlers;
    }
	
    public static HandlerList getHandlerList() 
    {
        return handlers;
    }
	
	public Player getPlayer() {
		return player;
	}
	
	public FailCause getCause() {
		return failCause;
	}

}

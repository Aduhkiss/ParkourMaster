package me.atticusthecoder.parkour.manager;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class NotificationManager {
	public static NotificationManager me;
	
	public static NotificationManager get() {
		if(me == null) {
			me = new NotificationManager();
		}
		return me;
	}
	
	private Map<Player, Boolean> notifications = new HashMap<Player, Boolean>();
	
	public boolean sendNotifications(Player player) {
		if(notifications.get(player) == null) { return false; }
		return notifications.get(player);
	}
	
	public void enableNotify(Player player) {
		notifications.put(player, true);
	}
	
	public void disableNotify(Player player) {
		notifications.put(player, false);
	}
	
	public void push(String message) {
		for(Player player : Bukkit.getOnlinePlayers()) {
			if(sendNotifications(player)) {
				player.sendMessage(message);
			}
		}
	}
}

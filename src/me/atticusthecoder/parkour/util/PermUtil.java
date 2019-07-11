package me.atticusthecoder.parkour.util;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PermUtil {
	public static boolean hasAccess(CommandSender sender, String permission) {
		if(sender instanceof Player) {
			if(sender.hasPermission("parkourmaster." + permission)) {
				return true;
			} else { return false; }
		} else {
			return true;
		}
	}
}

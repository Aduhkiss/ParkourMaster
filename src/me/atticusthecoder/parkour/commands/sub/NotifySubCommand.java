package me.atticusthecoder.parkour.commands.sub;

import org.bukkit.entity.Player;

import me.atticusthecoder.parkour.commands.SubCommand;
import me.atticusthecoder.parkour.manager.NotificationManager;
import net.md_5.bungee.api.ChatColor;

public class NotifySubCommand extends SubCommand {

	@Override
	public void execute(Player caller, String[] args) {
		boolean flag = NotificationManager.get().sendNotifications(caller);
		
		if(flag) {
			NotificationManager.get().disableNotify(caller);
			caller.sendMessage(ChatColor.GREEN + "You have disabled parkour completion notifications.");
			return;
		} else {
			NotificationManager.get().enableNotify(caller);
			caller.sendMessage(ChatColor.GREEN + "You have enabled parkour completion notifications.");
			return;
		}
	}
	
	

}

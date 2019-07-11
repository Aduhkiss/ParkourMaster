package me.atticusthecoder.parkour.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.atticusthecoder.parkour.commands.sub.NotifySubCommand;
import me.atticusthecoder.parkour.util.PermUtil;
import net.md_5.bungee.api.ChatColor;

public class ParkourCommand implements CommandExecutor {
	
	NotifySubCommand notifySubCommand;
	
	public ParkourCommand() {
		notifySubCommand = new NotifySubCommand();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You are Console! you cant do anything, rip");
			return false;
		}
		
		// get the player
		Player player = (Player) sender;
		
		// give them the commands
		if(args == null || args.length == 0) {
			sendHelp((Player) sender);
			return true;
		}
		
		// Check for the arguments
		if(args[0].equalsIgnoreCase("notify")) {
			if(!PermUtil.hasAccess(sender, "command.notify")) {
				sender.sendMessage(ChatColor.RED + "I'm sorry, but you do not have permission to perform this command.");
				return false;
			}
			notifySubCommand.execute(player, args);
			return true;
		}
		
		
		sendHelp((Player) sender);
		return true;
	}
	
	public void sendHelp(Player player) {
		player.sendMessage(ChatColor.RED + "/parkour notify");
	}

}

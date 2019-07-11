package me.atticusthecoder.parkour.commands;

import org.bukkit.entity.Player;

public abstract class SubCommand {
	public abstract void execute(Player caller, String[] args);
}

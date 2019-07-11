package me.atticusthecoder.parkour.data;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.atticusthecoder.parkour.Main;

public class Data {
	private static Data instance = new Data();
	
	public static Data getInstance() {
		return instance;
	}
	
	public Data() {
		this.DataFile = new File(Main.getPlugin().getDataFolder(), "data.yml");
		if(!this.DataFile.exists()) {
			try {
				this.DataFile.getParentFile().mkdirs();
				this.DataFile.createNewFile();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		this.Data = YamlConfiguration.loadConfiguration(this.DataFile);
	}
	
	private File DataFile;
	private FileConfiguration Data;
	
	public FileConfiguration getData() {
		return this.Data;
	}
	
	public void saveData() {
		try {
			this.Data.save(DataFile);
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}

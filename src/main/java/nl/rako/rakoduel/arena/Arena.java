package nl.rako.rakoduel.arena;

import nl.rako.rakoduel.RakoDuel;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Arena {
    private Location spawnlocation1;
    private Location spawnlocation2;
    private Location lobbyLocation;
    private String name;
    public File arenaConfigFile;
    public FileConfiguration arenaConfig;

    public FileConfiguration getArenaConfig() {
        return this.arenaConfig;
    }
    public File getArenaConfigFile() {
        return this.arenaConfigFile;
    }
    public void createArenaConfig() {
        arenaConfigFile = new File(RakoDuel.plugin.getDataFolder(), "arena.yml");
        if(!(arenaConfigFile.exists())) {
            arenaConfigFile.getParentFile().mkdirs();
            RakoDuel.plugin.saveResource("arena.yml", false);
        }

        arenaConfig = new YamlConfiguration();

        try {
            arenaConfig.load(arenaConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    public void writeArenaConfig() {
        try {
            RakoDuel.data.getArenaConfig().save(RakoDuel.data.getArenaConfigFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setArenaConfigFile(File file) {
        this.arenaConfigFile = file;
    }
    public void setArenaConfig(FileConfiguration arenaConfig) {
        this.arenaConfig = arenaConfig;
    }
    public Location getSpawnlocation1() {
        return spawnlocation1;
    }
    public Location getSpawnlocation2() {
        return spawnlocation2;
    }
    public Location getLobbyLocation() {
        return lobbyLocation;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;

    }
    public void setLobbyLocation(Location lobbyLocation) {
        this.lobbyLocation = lobbyLocation;
    }
    public void setSpawnlocation1(Location spawnLocation1) {
        this.spawnlocation1 = spawnLocation1;
    }
    public void setSpawnlocation2(Location spawnlocation2) {
        this.spawnlocation2 = spawnlocation2;
    }
}

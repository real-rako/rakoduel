package nl.rako.rakoduel.game;

import nl.rako.rakoduel.Functions.Console;
import nl.rako.rakoduel.RakoDuel;
import nl.rako.rakoduel.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.*;

import static nl.rako.rakoduel.RakoDuel.data;

public class Game {

    private String gameState;
    private ArrayList<UUID> gamePlayers = new ArrayList<UUID>();


    public void setGameState(String state)  {
        switch(state) {
            case "waiting":
                gameState = "waiting";
                setWaiting();
                break;
            case "starting":
                // Start game here
                gameState = "starting";
                break;
            case "going on":
                // something
                gameState = "going on";
                break;
            case "ending":
                // end game here
                gameState = "ending";
                break;
            default:
        }
    }
    public String getGameState() {
        return gameState;
    }
    public void addPlayer(Player player) {
        gamePlayers.add(player.getUniqueId());
    }
    public List getPlayers() {
        List<Player> listPlayers = new ArrayList<>();

        for(int i=0; i<gamePlayers.size();i++) {
            Player player = Bukkit.getPlayer(gamePlayers.get(i));
            listPlayers.add(player);
        }
        return listPlayers;
    }
    private void setWaiting() {
        for(int i=0; i<gamePlayers.size(); i++) {
            Player player = Bukkit.getPlayer(gamePlayers.get(i));
            Arena arena = getArenaFromConfig();
            Location lobbylocation = arena.getLobbyLocation();
            player.teleport(lobbylocation);
        }
    }
    private Arena getArenaFromConfig() {
        ConfigurationSection configurationSection = data.getArenaConfig().getConfigurationSection("arenas");
        Set<String> realList = configurationSection.getKeys(false);
        Random random = new Random();
        int randomi =  random.nextInt(realList.size());
        ArrayList<String> arenas = new ArrayList<String>();
        for(String all : realList) {
            arenas.add(all);
        }
        String randomArena = arenas.get(randomi);
        Arena arena = new Arena();
        ConfigurationSection configurationSection1 = data.getArenaConfig();
        arena.setLobbyLocation((Location) configurationSection1.get("arenas." + randomArena + ".lobbylocation"));
        arena.setSpawnlocation1((Location) configurationSection1.get("arenas." + randomArena + ".spawnLocation1"));
        arena.setSpawnlocation2((Location) configurationSection1.get("arenas." + randomArena + ".spawnLocation2"));
        arena.setName((String) configurationSection1.get("arenas." + randomArena + ".name"));
        return arena;
    }

    }
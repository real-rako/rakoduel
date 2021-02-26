package nl.rako.rakoduel.game;

import nl.rako.rakoduel.RakoDuel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
            Location lobbylocation = (Location) RakoDuel.data.getArenaConfig().get("arenas.test.lobbylocation");
            player.teleport(lobbylocation);
        }
    }

    }
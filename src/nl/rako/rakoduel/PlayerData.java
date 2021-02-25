package nl.rako.rakoduel;


import java.util.ArrayList;
import java.util.UUID;

public class PlayerData {
    private static ArrayList<UUID> gamePlayers = new ArrayList<UUID>();


    public ArrayList getGamePlayers() {
        return gamePlayers;
    }

}

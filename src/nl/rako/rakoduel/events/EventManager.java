package nl.rako.rakoduel.events;

import nl.rako.rakoduel.RakoDuel;
import org.bukkit.Bukkit;

public class EventManager {
    public static void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new OnPlayerJoin(), RakoDuel.plugin);
        Bukkit.getPluginManager().registerEvents(new OnPlayerQuit(), RakoDuel.plugin);
    }
}

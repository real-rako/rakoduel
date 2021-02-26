package nl.rako.rakoduel;

import nl.rako.rakoduel.Functions.Console;
import nl.rako.rakoduel.arena.Arena;
import nl.rako.rakoduel.commands.ArenaCommand;
import nl.rako.rakoduel.commands.GameCommand;
import nl.rako.rakoduel.events.EventManager;
import nl.rako.rakoduel.game.Game;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Set;

public class RakoDuel extends JavaPlugin {
    public static Plugin plugin;
    public static Arena data = new Arena();


    @Override
    public void onEnable() {
        plugin = this;
        EventManager.registerEvents();
        Console.sendConsole(ChatColor.GREEN + "rakoduels has been enabled!");
        this.getCommand("arena").setExecutor(new ArenaCommand());
        this.getCommand("game").setExecutor(new GameCommand());
        data.createArenaConfig();

    }


    @Override
    public void onDisable() {
        Console.sendConsole(ChatColor.RED + "rakoduels has been disabled");
    }
}

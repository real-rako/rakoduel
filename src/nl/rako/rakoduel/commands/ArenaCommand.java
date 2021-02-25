package nl.rako.rakoduel.commands;

import nl.rako.rakoduel.RakoDuel;
import nl.rako.rakoduel.arena.Arena;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.List;

public class ArenaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] arg) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
            return true;
        }
        else {
            Player player = ((Player) sender).getPlayer();

            if(player.hasPermission("rako.arena")) {
                if(arg.length < 1) {
                    player.sendMessage("Usage: ./arena <Argument>");

                }
                else {
                    if(arg[0].equalsIgnoreCase("create")) {
                        if(arg.length < 2) {
                            player.sendMessage("Usage: ./arena create <ArenaName>");
                        }
                        else {
                            String arenaName = arg[1];
                            RakoDuel.data.getArenaConfig().set("arenas." + arenaName + ".name", arenaName);
                            RakoDuel.data.writeArenaConfig();
                        }
                    }
                    else if(arg[0].equalsIgnoreCase("set")) {
                        if(arg.length < 3) {
                            player.sendMessage("Usage: ./arena set <ArenaName> loc1");
                        }
                        else {
                            if(arg[2].equalsIgnoreCase("loc1")) {
                                String arenaName = arg[1];
                                Location location = player.getLocation();
                                if(RakoDuel.data.getArenaConfig().contains("arenas." + arenaName)) {
                                    RakoDuel.data.getArenaConfig().set("arenas." + arenaName + ".spawnLocation1", location);
                                    RakoDuel.data.writeArenaConfig();
                                    player.sendMessage("Succesfully written location to config.");
                                }
                                else {
                                    player.sendMessage("That arena doesnt exist use ./arena create to create one");
                                }

                            }
                            else if(arg[2].equalsIgnoreCase("loc2")) {
                                String arenaName = arg[1];
                                Location location = player.getLocation();
                                if(RakoDuel.data.getArenaConfig().contains("arenas." + arenaName)) {
                                    RakoDuel.data.getArenaConfig().set("arenas." + arenaName + ".spawnLocation2", location);
                                    RakoDuel.data.writeArenaConfig();
                                    player.sendMessage("Succesfully written location to config.");
                                }
                                else {
                                    player.sendMessage("That arena doesnt exist use ./arena create to create one");
                                }

                            }
                            else if(arg[2].equalsIgnoreCase("lobbyloc")) {
                                String arenaName = arg[1];
                                Location location = player.getLocation();
                                if(RakoDuel.data.getArenaConfig().contains("arenas." + arenaName)) {
                                    RakoDuel.data.getArenaConfig().set("arenas." + arenaName + ".lobbylocation", location);
                                    RakoDuel.data.writeArenaConfig();
                                    player.sendMessage("Succesfully written location to config.");
                                }
                                else {
                                    player.sendMessage("That arena doesnt exist use ./arena create to create one");
                                }

                            }
                            else {
                                player.sendMessage("Usage: ./arena set <ArenaName> loc2");
                            }
                        }

                    }
                    else if(arg[0].equalsIgnoreCase("delete")) {
                        if(arg.length < 2) {
                            player.sendMessage("Usage: ./arena delete <ArenaName>");
                        }
                        else {
                            String arenaName = arg[1];
                            RakoDuel.data.getArenaConfig().set("arenas." + arenaName, null);
                            RakoDuel.data.writeArenaConfig();
                        }
                    }
                    else if(arg[0].equalsIgnoreCase("list")) {
                        ConfigurationSection cfg = RakoDuel.data.arenaConfig.getConfigurationSection("arenas");
                        for(String key : cfg.getKeys(false)) {
                            String name = RakoDuel.data.arenaConfig.getString("arenas." + key + ".name");
                            player.sendMessage(name);
                        }

                    }
                    else {
                        player.sendMessage("Usage: ./arena <Argument>");
                    }
                }
            }
            else {
                player.sendMessage(ChatColor.RED + "Insufficient permissions!");
            }
        }
        return true;
    }
}

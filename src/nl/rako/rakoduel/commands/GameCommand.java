package nl.rako.rakoduel.commands;

import nl.rako.rakoduel.game.Game;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] arg) {
        if(sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if(!arg[0].equalsIgnoreCase("create") || arg.length > 1) {
                player.sendMessage("Usage: ./game create");
            }
            else {
                Game game = new Game();
                game.addPlayer(player);
                game.setGameState("waiting");
                player.sendMessage(ChatColor.GREEN + "You have created a game");
            }
        }
        else {
            sender.sendMessage(ChatColor.RED + "You have to be a player to execute this command!");
        }
        return true;
    }
}

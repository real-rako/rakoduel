package nl.rako.rakoduel.Functions;

import org.bukkit.Bukkit;

public class Console {
     public static void sendConsole(String msg) {
         Bukkit.getConsoleSender().sendMessage(msg);
     }
}

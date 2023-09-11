package org.mrmelon__.statsupgrader;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ColorSay {

    public static void say(String message){ // Метод, который выводит в чат фиолетовое сообщение всем игрокам
        Bukkit.broadcastMessage("§5"+message);
    }

    public static void sayToPlayer(CommandSender commandSender, String message){ // Метод, который выводит в чат голубое сообщение всем игрокам
        commandSender.sendMessage("§3"+message);
    }

    public static void sayToPlayer(Player player, String message){ // Метод, который выводит в чат голубое сообщение всем игрокам
        player.sendMessage("§3"+message);
    }

    public static void sayToPlayerError(CommandSender commandSender, String message){ // Метод, который выводит в чат КРАСНОЕ сообщение всем игрокам
        commandSender.sendMessage("§4"+message);
    }

    public static void sayToPlayerError(Player player, String message){ // Метод, который выводит в чат КРАСНОЕ сообщение всем игрокам
        player.sendMessage("§4"+message);
    }

}

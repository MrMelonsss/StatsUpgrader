package org.mrmelon__.statsupgrader.admins;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Admins {
    private static ArrayList<String> admins = new ArrayList<>(); // Список всех админов

    public static boolean adminChecker(CommandSender commandSender){ // Проверка игрока на то, есть ли он в списке админов (Или проверка на то, что сендер консоль)
        if (commandSender instanceof Player){ // Игрок ли сендер?
            if (commandSender.isOp() || admins.contains(commandSender.getName())) return true; // Проверка на опку у игрока или проверка на присутствие игрока в админ листе
            return false;
        }
        return true;
    }

    public static void addAdmin(String nickname){ // Метод, добавляющий админа в админ лист
        admins.add(nickname);
    }

    public static ArrayList getAdmins(){ // Метод, возвращающий список админов
        return admins;
    }

}

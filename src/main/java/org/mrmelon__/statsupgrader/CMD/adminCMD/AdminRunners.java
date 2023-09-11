package org.mrmelon__.statsupgrader.CMD.adminCMD;

import org.bukkit.command.CommandSender;
import org.mrmelon__.statsupgrader.ColorSay;
import org.mrmelon__.statsupgrader.admins.Admins;
import org.mrmelon__.statsupgrader.users.Users;

public class AdminRunners {

    public static void add(CommandSender commandSender, String nickname){ // Метод-Чекер, добавляющий админа в админ лист
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            Admins.addAdmin(nickname);
            ColorSay.sayToPlayer(commandSender,"Success add of "+nickname+" in admin list");
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

    public static void list(CommandSender commandSender){ // Метод-Чекер, возвращающий список админов
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            ColorSay.sayToPlayer(commandSender,"Admin list: "+(Admins.getAdmins()));
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

    public static void userlist(CommandSender commandSender){ // Метод-Чекер, возвращающий список админов
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            ColorSay.sayToPlayer(commandSender,"User list: "+(Users.getUsers()));
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

}

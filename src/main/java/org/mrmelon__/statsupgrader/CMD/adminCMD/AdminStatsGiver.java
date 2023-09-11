package org.mrmelon__.statsupgrader.CMD.adminCMD;

import org.bukkit.command.CommandSender;
import org.mrmelon__.statsupgrader.ColorSay;
import org.mrmelon__.statsupgrader.admins.Admins;
import org.mrmelon__.statsupgrader.users.Users;
import org.mrmelon__.statsupgrader.users.UsersStats;

public class AdminStatsGiver {

    public static void getUsersPlayTimeStats(CommandSender commandSender, String name) {
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            if (Users.getUsers().contains(name)) {
                ColorSay.sayToPlayer(commandSender, "PlayTime: "+name+" "+(UsersStats.getUsersPlayTimeStats().get(name)));
            } else ColorSay.sayToPlayerError(commandSender,"This player is not defined");
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

    public static void getUsersPlayTimeStatsAll(CommandSender commandSender) {
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            ColorSay.sayToPlayer(commandSender, "PlayTime: " + (UsersStats.getUsersPlayTimeStats()));
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

    public static void getUsersLastSeenStats(CommandSender commandSender) {
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            ColorSay.sayToPlayer(commandSender,"Admin list: "+(Admins.getAdmins()));
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

    public static void getUsersKillMobCountStats(CommandSender commandSender) {
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            ColorSay.sayToPlayer(commandSender,"Admin list: "+(Admins.getAdmins()));
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

    public static void getUsersBreakBlockCountStats(CommandSender commandSender) {
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            ColorSay.sayToPlayer(commandSender,"Admin list: "+(Admins.getAdmins()));
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

    public static void getUsersDeathCountStats(CommandSender commandSender) {
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            ColorSay.sayToPlayer(commandSender,"Admin list: "+(Admins.getAdmins()));
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

}

package org.mrmelon__.statsupgrader.CMD.adminCMD;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mrmelon__.statsupgrader.ColorSay;
import org.mrmelon__.statsupgrader.admins.Admins;
import org.mrmelon__.statsupgrader.lastseen.LastSeen;
import org.mrmelon__.statsupgrader.playerstime.PlayTime;
import org.mrmelon__.statsupgrader.users.Users;
import org.mrmelon__.statsupgrader.users.UsersStats;

public class AdminStatsGiver {

    public static void getUsersPlayTimeStats(CommandSender commandSender, String name) {
        // Обновляем статистику сыгранного времени у юзера
        Player player = (Player) commandSender;
        PlayTime.setQuittime(player);
        PlayTime.setPlayTimeStats(player);
        PlayTime.setJointime(player);
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            if (Users.getUsers().contains(name)) { // Чекер на юзера
                ColorSay.sayToPlayer(commandSender, "PlayTime: "+name+" "+(UsersStats.getUsersPlayTimeStats().get(name)));
            } else ColorSay.sayToPlayerError(commandSender,"This player is not defined");
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

    public static void getUsersPlayTimeStatsAll(CommandSender commandSender) {
        for (Player player : PlayTime.getJointime().keySet()){ // Обновляем статистику сыгранного времени у всех юзеров, которые онлайн
            PlayTime.setQuittime(player);
            PlayTime.setPlayTimeStats(player);
            PlayTime.setJointime(player);
        }
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            ColorSay.sayToPlayer(commandSender, "PlayTime: " + (UsersStats.getUsersPlayTimeStats()));
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

    public static void getUsersLastSeenStats(CommandSender commandSender, String name) {
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            ColorSay.sayToPlayer(commandSender,"LastSeen: "+(UsersStats.getUsersLastSeenStats().get(name)));
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }
    public static void getUsersLastSeenStatsAll(CommandSender commandSender) {
        for (Player player : PlayTime.getJointime().keySet()){ // Обновляем статистику онлайна у всех юзеров, которые онлайн
            LastSeen.checkLastSeenOrOnline(player);
        }
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            ColorSay.sayToPlayer(commandSender, "LastSeen: " + (UsersStats.getUsersLastSeenStats()));
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

    public static void getUsersKillMobCountStats(CommandSender commandSender,String name) {
        Player player = (Player) commandSender;
        UsersStats.setUsersKillMobCountStatsPerson(player.getName(),player.getStatistic(Statistic.MOB_KILLS));
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            ColorSay.sayToPlayer(commandSender,"KillMobCount: "+(UsersStats.getUsersKillMobCountStats().get(name)));
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

    public static void getUsersKillMobCountStatsAll(CommandSender commandSender) {
        for (Player player : PlayTime.getJointime().keySet()){ // Обновляем статистику сыгранного времени у всех юзеров, которые онлайн
            UsersStats.setUsersKillMobCountStatsPerson(player.getName(),player.getStatistic(Statistic.MOB_KILLS));
        }
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            ColorSay.sayToPlayer(commandSender,"KillMobCount: "+(UsersStats.getUsersKillMobCountStats()));
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

    public static void getUsersBreakBlockCountStats(CommandSender commandSender, String name) {
        Player player = (Player) commandSender;
        UsersStats.setUsersBreakBlockCountStatsPerson(player.getName(),player.getStatistic(Statistic.MINE_BLOCK, Material.GRASS_BLOCK));
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            if (Users.getUsers().contains(name)) {
                ColorSay.sayToPlayer(commandSender,"Break block count: "+name+" "+(UsersStats.getUsersBreakBlockCountStats().get(name)));
            } else ColorSay.sayToPlayerError(commandSender,"This player is not defined");
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

    public static void getUsersBreakBlockCountStatsAll(CommandSender commandSender) {
        for (Player player : PlayTime.getJointime().keySet()){ // Обновляем статистику сыгранного времени у всех юзеров, которые онлайн
            UsersStats.setUsersBreakBlockCountStatsPerson(player.getName(),player.getStatistic(Statistic.MINE_BLOCK, Material.GRASS_BLOCK));
        }
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            ColorSay.sayToPlayer(commandSender,"Break block count: "+(UsersStats.getUsersBreakBlockCountStats()));
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

    public static void getUsersDeathCountStats(CommandSender commandSender,String name) {
        Player player = (Player) commandSender;
        UsersStats.setUsersDeathCountStatsPerson(player.getName(),player.getStatistic(Statistic.DEATHS));
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            if (Users.getUsers().contains(name)) {
                ColorSay.sayToPlayer(commandSender,"Death count: "+name+" "+(UsersStats.getUsersDeathCountStats().get(name)));
            } else ColorSay.sayToPlayerError(commandSender,"This player is not defined");
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

    public static void getUsersDeathCountStatsAll(CommandSender commandSender){
        for (Player player : PlayTime.getJointime().keySet()){ // Обновляем статистику сыгранного времени у всех юзеров, которые онлайн
            UsersStats.setUsersDeathCountStatsPerson(player.getName(),player.getStatistic(Statistic.DEATHS));
        }
        if (Admins.adminChecker(commandSender)) { // Чекер на админа
            ColorSay.sayToPlayer(commandSender,"Death count: "+(UsersStats.getUsersDeathCountStats()));
        } else ColorSay.sayToPlayerError(commandSender,"You don't permissions for this action");
    }

}

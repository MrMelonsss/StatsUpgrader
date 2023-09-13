package org.mrmelon__.statsupgrader.playerstime;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.mrmelon__.statsupgrader.users.UsersStats;

import java.util.HashMap;
import java.util.Map;

public class PlayTime {

    private static Map<Player, Integer> jointime = new HashMap();
    private static Map<Player, Integer> quittime = new HashMap();

    public static Map<Player, Integer> getJointime() {
        return jointime;
    }

    public static Map<Player, Integer> getQuittime() {
        return quittime;
    }

    public static void remove(Player player){
        jointime.remove(player);
        quittime.remove(player);
    }

    public static void setPlayTimeStats(Player player){
        int starttime = jointime.get(player);
        int endtime = quittime.get(player);
        int result = endtime-starttime;
        int old = UsersStats.getUsersPlayTimeStatsPerson(player.getName());
        UsersStats.setUsersPlayTimeStatsPerson(player.getName(),old+result);
    }

    public static void setJointime(Player player) {
        jointime.put(player, player.getStatistic(Statistic.TOTAL_WORLD_TIME));
    }


    public static void setQuittime(Player player) {
        quittime.put(player, player.getStatistic(Statistic.TOTAL_WORLD_TIME));
    }

    public static int getJointime(Player player) {
        return jointime.get(player);
    }

    public static int getQuittime(Player player) {
        return quittime.get(player);
    }
}

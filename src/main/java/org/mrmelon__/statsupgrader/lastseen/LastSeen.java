package org.mrmelon__.statsupgrader.lastseen;

import org.bukkit.entity.Player;
import org.mrmelon__.statsupgrader.playerstime.PlayTime;
import org.mrmelon__.statsupgrader.users.UsersStats;

import java.util.HashMap;
import java.util.Map;

public class LastSeen {

    public static void addLastSeen(String player){
        java.time.LocalDateTime date = java.time.LocalDateTime.now();
        UsersStats.setUsersLastSeenStatsPerson(player, String.valueOf(date));
    }

    public static void checkLastSeenOrOnline(Player player){
        if (PlayTime.getJointime().containsKey(player)){
            UsersStats.setUsersLastSeenStatsPerson(player.getName(), "now online");
        } else {
            addLastSeen(player.getName());
        }
    }

}

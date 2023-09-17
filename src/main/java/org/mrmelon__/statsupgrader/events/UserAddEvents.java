package org.mrmelon__.statsupgrader.events;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.mrmelon__.statsupgrader.users.Users;
import org.mrmelon__.statsupgrader.users.UsersStats;

public class UserAddEvents implements Listener {

    @EventHandler
    public void joinUser(PlayerJoinEvent event){ // Событие, которое добавляет новых юзеров и вызывает StatisticAdder
        String nickname = event.getPlayer().getName();
        Player player = (Player) event.getPlayer();
        if (!(Users.userChecker(nickname))) {
            Users.addUser(nickname);
            event.setJoinMessage("§6"+nickname+" Joined the server for the first time");
            UsersStats.addStats(nickname,0,"LS",player.getStatistic(Statistic.MOB_KILLS),
                    player.getStatistic(Statistic.MINE_BLOCK, Material.GRASS_BLOCK),player.getStatistic(Statistic.DEATHS));
        } else {
            UsersStats.addStats(nickname, UsersStats.getUsersPlayTimeStats().get(nickname), "LS", player.getStatistic(Statistic.MOB_KILLS),
                    player.getStatistic(Statistic.MINE_BLOCK, Material.GRASS_BLOCK), player.getStatistic(Statistic.DEATHS));
        }
    }


}

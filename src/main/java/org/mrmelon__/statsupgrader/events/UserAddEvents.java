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
        if (!(Users.userChecker(nickname))) {
            Users.addUser(nickname);
            event.setJoinMessage("§6"+nickname+" Joined the server for the first time");
        }
        Player player = (Player) event.getPlayer();
        UsersStats.addStats(nickname,player.getStatistic(Statistic.TOTAL_WORLD_TIME),nickname,player.getStatistic(Statistic.MOB_KILLS),
                player.getStatistic(Statistic.MINE_BLOCK, Material.GRASS_BLOCK),player.getStatistic(Statistic.DEATHS));
    }

    // Доделать Event Quit для того, чтобы вычислять нормальное время игры у Player'а

}

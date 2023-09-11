package org.mrmelon__.statsupgrader.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.mrmelon__.statsupgrader.users.Users;

public class UserAddEvents implements Listener {

    @EventHandler
    public void joinUser(PlayerJoinEvent event){ // Событие, которое добавляет новых юзеров
        String nickname = event.getPlayer().getName();
        if (!(Users.userChecker(nickname))) {
            Users.addUser(nickname);
            event.setJoinMessage("§6"+nickname+" Joined the server for the first time");
        }
    }

}

package org.mrmelon__.statsupgrader.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mrmelon__.statsupgrader.lastseen.LastSeen;

public class LastSeenEvent implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent event){
        LastSeen.checkLastSeenOrOnline(event.getPlayer());
    }
    @EventHandler
    public void quit(PlayerQuitEvent event){
        LastSeen.checkLastSeenOrOnline(event.getPlayer());
    }

}

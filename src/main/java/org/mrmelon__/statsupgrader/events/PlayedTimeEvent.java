package org.mrmelon__.statsupgrader.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mrmelon__.statsupgrader.playerstime.PlayTime;

public class PlayedTimeEvent implements Listener {

    @EventHandler
    public void playedTimeJoin(PlayerJoinEvent event){
        PlayTime.setJointime(event.getPlayer());
    }

    @EventHandler
    public void playedTimeQuit(PlayerQuitEvent event){
        PlayTime.setQuittime(event.getPlayer());
        PlayTime.setPlayTimeStats(event.getPlayer());
        PlayTime.remove(event.getPlayer());
    }

}

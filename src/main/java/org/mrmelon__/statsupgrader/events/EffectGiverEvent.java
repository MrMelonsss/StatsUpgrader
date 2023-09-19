package org.mrmelon__.statsupgrader.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.mrmelon__.statsupgrader.Main;
import org.mrmelon__.statsupgrader.users.upgrades.UsersUpgrades;

public class EffectGiverEvent implements Listener {

    @EventHandler
    public void timerJoin(PlayerJoinEvent event){
        Bukkit.getScheduler().runTaskTimer(Main.getInstaces(),() -> {
            UsersUpgrades.setAllFromStats(event.getPlayer());
            UsersUpgrades.giveLevelsEffects(event.getPlayer());
        },1,20);
    }

}

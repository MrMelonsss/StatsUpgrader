package org.mrmelon__.statsupgrader.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.mrmelon__.statsupgrader.Main;
import org.mrmelon__.statsupgrader.users.upgrades.UsersUpgrades;


public class EffectGiverEvent implements Listener {

    @EventHandler
    public void timerJoin(PlayerJoinEvent event){
        new BukkitRunnable(){
            @Override
            public void run() {
                try {
                    UsersUpgrades.setAllFromStats(event.getPlayer());
                    UsersUpgrades.giveLevelsEffects(event.getPlayer());
                } catch (Exception e){
                    this.cancel();
                }
            }
        }.runTaskTimer(Main.getInstaces(),20L,20L);
    }

}

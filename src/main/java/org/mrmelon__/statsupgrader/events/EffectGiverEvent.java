package org.mrmelon__.statsupgrader.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.mrmelon__.statsupgrader.Main;
import org.mrmelon__.statsupgrader.users.upgrades.UsersUpgrades;

import java.util.concurrent.atomic.AtomicInteger;

public class EffectGiverEvent implements Listener {

    @EventHandler
    public void timerJoin(PlayerJoinEvent event){
        AtomicInteger flag = new AtomicInteger();
        flag.set(0);
        int taskId = Bukkit.getScheduler().runTaskTimer(Main.getInstaces(),() -> {
            try {
                System.out.println("Func");
                UsersUpgrades.setAllFromStats(event.getPlayer());
                UsersUpgrades.giveLevelsEffects(event.getPlayer());
            } catch (Exception e){
                flag.set(1);
            }

            },20,20).getTaskId();
        while (true){
            if (flag.get()==1){
                System.out.println("if");
                Bukkit.getScheduler().cancelTask(taskId);
            }
        }
    }

}

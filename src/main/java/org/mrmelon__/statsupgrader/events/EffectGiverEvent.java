package org.mrmelon__.statsupgrader.events;

import com.google.common.eventbus.DeadEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.mrmelon__.statsupgrader.users.upgrades.UsersUpgrades;

public class EffectGiverEvent implements Listener {

    @EventHandler
    public void joinEv(PlayerJoinEvent event){
        UsersUpgrades.setAllFromStats(event.getPlayer());
        UsersUpgrades.giveLevelsEffects(event.getPlayer());
    }

    @EventHandler
    public void breakEv(BlockBreakEvent event){
        UsersUpgrades.setAllFromStats(event.getPlayer());
        UsersUpgrades.giveLevelsEffects(event.getPlayer());
    }

    @EventHandler
    public void deathEv(PlayerDeathEvent event){
        UsersUpgrades.setAllFromStats(event.getEntity().getPlayer());
        UsersUpgrades.giveLevelsEffects(event.getEntity().getPlayer());
    }

    @EventHandler
    public void killEv(EntityDeathEvent event){
        UsersUpgrades.setAllFromStats(event.getEntity().getKiller());
        UsersUpgrades.giveLevelsEffects(event.getEntity().getKiller());
    }

    @EventHandler
    public void killEv(PlayerRespawnEvent event){
        UsersUpgrades.setAllFromStats(event.getPlayer());
        UsersUpgrades.giveLevelsEffects(event.getPlayer());
    }

}

package org.mrmelon__.statsupgrader;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.mrmelon__.statsupgrader.CMD.StatsCMD;
import org.mrmelon__.statsupgrader.CMD.adminCMD.AdminCommandsCMD;
import org.mrmelon__.statsupgrader.CMD.adminCMD.AdminCommandsCompleter;
import org.mrmelon__.statsupgrader.events.*;

public final class Main extends JavaPlugin {

    private static Main plugin;

    public static Main getInstaces(){
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        getCommand("stats").setExecutor(new StatsCMD());
        getCommand("adminsu").setExecutor(new AdminCommandsCMD());
        getCommand("adminsu").setTabCompleter(new AdminCommandsCompleter());

        Bukkit.getPluginManager().registerEvents(new InventoryEvents(), this);
        Bukkit.getPluginManager().registerEvents(new UserAddEvents(), this);
        Bukkit.getPluginManager().registerEvents(new PlayedTimeEvent(),this);
        Bukkit.getPluginManager().registerEvents(new LastSeenEvent(),this);
        Bukkit.getPluginManager().registerEvents(new EffectGiverEvent(), this);
    }

    @Override
    public void onDisable() {
    }
}

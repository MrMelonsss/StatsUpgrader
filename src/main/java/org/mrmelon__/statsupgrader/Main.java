package org.mrmelon__.statsupgrader;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.mrmelon__.statsupgrader.CMD.StatsCMD;
import org.mrmelon__.statsupgrader.CMD.adminCMD.AdminCommandsCMD;
import org.mrmelon__.statsupgrader.CMD.adminCMD.AdminCommandsCompleter;
import org.mrmelon__.statsupgrader.events.InventoryEvents;
import org.mrmelon__.statsupgrader.events.UserAddEvents;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("stats").setExecutor(new StatsCMD());
        getCommand("adminsu").setExecutor(new AdminCommandsCMD());
        getCommand("adminsu").setTabCompleter(new AdminCommandsCompleter());

        Bukkit.getPluginManager().registerEvents(new InventoryEvents(), this);
        Bukkit.getPluginManager().registerEvents(new UserAddEvents(), this);
    }

    @Override
    public void onDisable() {
    }
}

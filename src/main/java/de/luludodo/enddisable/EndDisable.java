package de.luludodo.enddisable;

import de.luludodo.enddisable.commands.EndCommand;
import de.luludodo.enddisable.listeners.PlayerInteractEventListener;
import de.luludodo.enddisable.listeners.PlayerPortalEventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class EndDisable extends JavaPlugin {
    private static EndDisable instance;
    public static EndDisable getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        getCommand("end").setExecutor(new EndCommand());
        getCommand("end").setTabCompleter(new EndCommand());

        getServer().getPluginManager().registerEvents(new PlayerInteractEventListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerPortalEventListener(), this);

        getLogger().info("Enabled EndDisable");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Disabled EndDisable");
    }
}

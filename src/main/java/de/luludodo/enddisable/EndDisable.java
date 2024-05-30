package de.luludodo.enddisable;

import de.luludodo.enddisable.commands.EndCommand;
import de.luludodo.enddisable.listeners.PlayerInteractEventListener;
import de.luludodo.enddisable.listeners.PlayerPortalEventListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class EndDisable extends JavaPlugin {
    private static Logger log;
    private static FileConfiguration config;
    private static EndDisable instance;

    @Override
    public void onEnable() {
        log = getLogger();
        config = getConfig();
        instance = this;

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        getCommand("end").setExecutor(new EndCommand());
        getCommand("end").setTabCompleter(new EndCommand());

        getServer().getPluginManager().registerEvents(new PlayerInteractEventListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerPortalEventListener(), this);

        log.info("Enabled EndDisable!");
    }

    public static void save() {
        instance.saveConfig();
    }

    public static void reload() {
        instance.reloadConfig();
    }

    public static Logger logger() {
        return log;
    }

    public static FileConfiguration config() {
        return config;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info("Disabled EndDisable!");
    }
}

package uk.co.proxying.aAnvilBlacklist;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.proxying.aAnvilBlacklist.listeners.RenameListener;

public final class AanvilBlacklist extends JavaPlugin {

    public static AanvilBlacklist getInstance() {
        return instance;
    }

    private static AanvilBlacklist instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new RenameListener(), this);
    }

    @Override
    public void onDisable() {
    }
}

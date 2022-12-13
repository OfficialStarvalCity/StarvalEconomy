package de.starvalcity.starvaleconomy;

import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    Corebase corebase = new Corebase();

    private static Core instance;

    @Override
    public void onEnable() {
        instance = this;

        corebase.initialize();
    }

    @Override
    public void onDisable() {

    }

    public static Core getInstance() {
        return instance;
    }

}

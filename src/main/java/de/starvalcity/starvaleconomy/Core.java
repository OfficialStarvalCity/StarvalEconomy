package de.starvalcity.starvaleconomy;

import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    Corebase corebase = new Corebase();

    @Override
    public void onEnable() {
        corebase.initialize();
    }

    @Override
    public void onDisable() {



    }
}

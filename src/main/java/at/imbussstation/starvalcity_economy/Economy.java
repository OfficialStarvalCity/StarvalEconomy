package at.imbussstation.starvalcity_economy;

import at.imbussstation.starvalcity_economy.sql.SQLHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Economy extends JavaPlugin {
    private static Economy instance;

    @Override
    public void onEnable() {
        instance = this;

        SQLHandler.connect(instance);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Economy getInstance() {
        return instance;
    }
}

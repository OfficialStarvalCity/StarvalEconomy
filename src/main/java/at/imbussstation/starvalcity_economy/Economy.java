package at.imbussstation.starvalcity_economy;

import at.imbussstation.starvalcity_economy.commands.Eco_CMD;
import at.imbussstation.starvalcity_economy.handler.balance.BalanceHandler;
import at.imbussstation.starvalcity_economy.listener.PlayerJoinListener;
import at.imbussstation.starvalcity_economy.listener.PlayerQuitListener;
import at.imbussstation.starvalcity_economy.sql.SQLFunctions;
import at.imbussstation.starvalcity_economy.sql.SQLHandler;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Economy extends JavaPlugin {
    private static Economy instance;

    private SQLFunctions sqlFunctions;
    private BalanceHandler balanceHandler;

    @Override
    public void onEnable() {
        instance = this;

        SQLHandler.connect(instance);
        SQLHandler.createTables();

        this.sqlFunctions = new SQLFunctions(SQLHandler.database);
        this.balanceHandler = new BalanceHandler(instance, sqlFunctions);

        loadCommands();
        loadListener();
    }

    public void loadListener() {
        new PlayerJoinListener(this, balanceHandler);
        new PlayerQuitListener(this, balanceHandler);
    }

    public void loadCommands() {
        new Eco_CMD(this, "eco");
    }

    @Override
    public void onDisable() {
        balanceHandler.saveAll();
        SQLHandler.disconnect();
    }

    public static Economy getInstance() {
        return instance;
    }
}

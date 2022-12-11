package de.starvalcity.starvaleconomy;

import de.starvalcity.starvaleconomy.commands.MoneyCommand;
import de.starvalcity.starvaleconomy.database.BackendHandler;
import de.starvalcity.starvaleconomy.database.SQL;
import org.bukkit.plugin.java.JavaPlugin;

public class Corebase {

    private static Corebase corebase = new Corebase();

    public BackendHandler backendHandler = new BackendHandler();

    public void initialize() {
        initializeDatabase();
        loadCommands();
    }

    public void loadCommands() {
        MoneyCommand moneyCommand = new MoneyCommand(JavaPlugin.getPlugin(Core.class));
        JavaPlugin.getPlugin(Core.class).getCommand("money").setExecutor(moneyCommand);
    }

    public void loadEvents() {

    }

    public void initializeDatabase() {
        SQL.setupAccountsTable();
        SQL.setupBanksTable();
    }

    public BackendHandler getBackendHandler() {
        return backendHandler;
    }
}

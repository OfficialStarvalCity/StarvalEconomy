package de.starvalcity.starvaleconomy;

import de.starvalcity.starvaleconomy.commands.BankCommand;
import de.starvalcity.starvaleconomy.commands.MoneyCommand;
import de.starvalcity.starvaleconomy.commands.PayDayCommand;
import de.starvalcity.starvaleconomy.database.BackendHandler;
import de.starvalcity.starvaleconomy.database.SQL;
import de.starvalcity.starvaleconomy.handling.InterfaceActionHandler;
import de.starvalcity.starvaleconomy.handling.InterfaceHandler;
import de.starvalcity.starvaleconomy.handling.PayDayHandler;
import de.starvalcity.starvaleconomy.handling.ValueHandler;
import de.starvalcity.starvaleconomy.listeners.FirstPayListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Corebase {

    public BackendHandler backendHandler = new BackendHandler();
    public InterfaceHandler interfaceHandler = new InterfaceHandler();
    public InterfaceActionHandler interfaceActionHandler = new InterfaceActionHandler();
    public PayDayHandler payDayHandler = new PayDayHandler();
    public ValueHandler valueHandler = new ValueHandler();

    public void initialize() {
        initializeDatabase();
        loadCommands();
        loadEvents();
        loadListeners();
    }


    public void loadCommands() {
        BankCommand bankCommand = new BankCommand(JavaPlugin.getPlugin(Core.class));
        JavaPlugin.getPlugin(Core.class).getCommand("bank").setExecutor(bankCommand);

        MoneyCommand moneyCommand = new MoneyCommand(JavaPlugin.getPlugin(Core.class));
        JavaPlugin.getPlugin(Core.class).getCommand("money").setExecutor(moneyCommand);

        PayDayCommand payDayCommand = new PayDayCommand(JavaPlugin.getPlugin(Core.class));
        JavaPlugin.getPlugin(Core.class).getCommand("payday").setExecutor(payDayCommand);
    }

    public void loadEvents() {

    }

    public void loadListeners() {
        Bukkit.getServer().getPluginManager().registerEvents(new InterfaceActionHandler(), JavaPlugin.getPlugin(Core.class));
        Bukkit.getServer().getPluginManager().registerEvents(new FirstPayListener(), JavaPlugin.getPlugin(Core.class));
    }

    public void initializeDatabase() {
        SQL.setupAccountsTable();
        SQL.setupBanksTable();
    }

    public BackendHandler getBackendHandler() {
        return backendHandler;
    }

    public InterfaceHandler getInterfaceHandler() {
        return interfaceHandler;
    }

    public InterfaceActionHandler getInterfaceActionHandler() {
        return interfaceActionHandler;
    }

    public PayDayHandler getPayDayHandler() {
        return payDayHandler;
    }

    public ValueHandler getValueHandler() {
        return valueHandler;
    }
}

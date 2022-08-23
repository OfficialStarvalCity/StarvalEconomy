package at.imbussstation.starvalcity_economy.handler.balance;

import at.imbussstation.starvalcity_economy.sql.SQLFunctions;
import at.imbussstation.starvalcity_economy.sql.SQLHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class BalanceHandler {
    public static final HashMap<UUID, Balance> BALANCE_HOLDER = new HashMap<>();
    private JavaPlugin javaPlugin;
    private SQLFunctions sqlFunctions;

    public BalanceHandler(JavaPlugin javaPlugin, SQLFunctions sqlFunctions) {
        this.javaPlugin = javaPlugin;
        this.sqlFunctions = sqlFunctions;
    }

    public void loadFromDatabase(UUID uuid) {
        double money = sqlFunctions.getDouble("eco", "money", "uuid", uuid.toString());
        javaPlugin.getLogger().severe("Loaded " + money + " from database for " + uuid.toString());
        BALANCE_HOLDER.put(uuid, new Balance(uuid, money));
    }

    public void saveToDatabase(Balance balance) {
        if(!BALANCE_HOLDER.containsKey(balance.getUuid()))
            return;

        SQLHandler.database.update("INSERT INTO eco (uuid,value) VALUES ('" + balance.getUuid().toString() + "','" + balance.getBalance() + "') ON DUPLICATE KEY UPDATE value = '" + balance.getBalance() + "'");
        javaPlugin.getLogger().severe("Saved " + balance.getBalance() + " to database for " + balance.getUuid().toString());
    }

    public void saveAll() {
        for (Balance balance : BALANCE_HOLDER.values())
            saveToDatabase(balance);
    }


}

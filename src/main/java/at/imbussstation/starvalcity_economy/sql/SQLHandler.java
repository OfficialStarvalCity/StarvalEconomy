package at.imbussstation.starvalcity_economy.sql;

import org.bukkit.plugin.java.JavaPlugin;


public class SQLHandler {
    public static Database database;

    public static void connect(JavaPlugin javaPlugin) {
        //database = new Database("univastro.net", "3306", "economy", "starvalcity_dev", "KDLJ5WBNRO5GsjWD");       //StarvalCity Database
        database = new Database("localhost", "3306", "economy", "root", "");     //Local Database
        javaPlugin.getLogger().severe(database.getHost() + ":" + database.getPort() + ":" + database.getDatenbank() + ":" + database.getUser() + ":" + database.getPassword());
        database.connect();
    }

    public static void createTables() {
        database.createTable("eco", "uuid VARCHAR(100), value DOUBLE, PRIMARY KEY (`uuid`)");
    }

    public static void disconnect() {
        database.disconnect();
    }
}

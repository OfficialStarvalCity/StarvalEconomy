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
        database.createTable("prefix", "groupName VARCHAR(100), prefix VARCHAR(100), suffix VARCHAR(100), color VARCHAR(100), level INT, PRIMARY KEY (`groupName`)");
        database.createTable("hide", "uuid VARCHAR(100), timestamp timestamp NOT NULL DEFAULT current_timestamp() , PRIMARY KEY (`uuid`)");
        database.createTable("settings", "identifier VARCHAR(100), value VARCHAR(100), PRIMARY KEY (`identifier`)");
        database.createTable("translationSettings", "identifier VARCHAR(100), value VARCHAR(100), PRIMARY KEY (`identifier`)");
        database.createTable("selectedLanguages", "uuid VARCHAR(100), language VARCHAR(100), PRIMARY KEY (`uuid`)");
    }

    public static void disconnect() {
        database.disconnect();
    }
}

package de.starvalcity.starvaleconomy.database;

import de.starvalcity.base.api.def.database.MySQLAPI;

public class SQL {

    static String liquidBanksTableQuery = "CREATE TABLE `Banken` (" +
            "`ID` varchar(30), " +
            "`Name` varchar(30), " +
            "`Gründer` varchar(30), " +
            "`Inhaber` varchar(30), " +
            "`Kontostand` double(64,2), " +
            "`Konten` varchar(30), " +
            "PRIMARY KEY (`ID`));";

    static String liquidAccountsTableQuery = "CREATE TABLE `Bankkonten` (" +
            "`ID` varchar(30), " +
            "`Name` varchar(30), " +
            "`Gründer` varchar(30), " +
            "`Typ` varchar(30), " +
            "`Inhaber` varchar(64), " +
            "`Moderatoren` varchar(64), " +
            "`Mitglieder` varchar(64), " +
            "`Kontostand` double(64,2), " +
            "PRIMARY KEY (`ID`));";

    /**
     * Setup: LiquidBanks Tabelle
     */
    public static void setupBanksTable() {
        if (!MySQLAPI.existsTable("Banken")) {
            MySQLAPI.execute(liquidBanksTableQuery);
        }
    }

    /**
     * Setup: LiquidAccounts Tabelle
     */
    public static void setupAccountsTable() {
        if (!MySQLAPI.existsTable("Bankkonten")) {
            MySQLAPI.execute(liquidAccountsTableQuery);
        }
    }
}

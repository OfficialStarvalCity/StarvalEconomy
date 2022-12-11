package de.starvalcity.starvaleconomy.database;

import de.starvalcity.base.api.def.database.MySQLAPI;

public class SQL {

    static String liquidBanksTableQuery = "CREATE TABLE `LiquidBanks` (" +
            "`ID` varchar(30), " +
            "`Name` varchar(30), " +
            "`Founder` varchar(30), " +
            "`Owner` varchar(30), " +
            "`Balance` double(64,2), " +
            "`Accounts` varchar(30), " +
            "PRIMARY KEY (`ID`));";

    static String liquidAccountsTableQuery = "CREATE TABLE `LiquidAccounts` (" +
            "`ID` varchar(30), " +
            "`Name` varchar(30), " +
            "`Creator` varchar(30), " +
            "`Type` varchar(30), " +
            "`Owner` varchar(64), " +
            "`Moderators` varchar(64), " +
            "`Members` varchar(64), " +
            "`Balance` double(64,2), " +
            "PRIMARY KEY (`ID`));";

    /**
     * Setup: LiquidBanks Tabelle
     */
    public static void setupBanksTable() {
        if (!MySQLAPI.existsTable("LiquidBanks")) {
            MySQLAPI.execute(liquidBanksTableQuery);
        }
    }

    /**
     * Setup: LiquidAccounts Tabelle
     */
    public static void setupAccountsTable() {
        if (!MySQLAPI.existsTable("LiquidAccounts")) {
            MySQLAPI.execute(liquidAccountsTableQuery);
        }
    }
}

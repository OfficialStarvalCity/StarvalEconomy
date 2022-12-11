package de.starvalcity.starvaleconomy.database;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.api.handling.object.ObjectSQLManager;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BackendHandler {

    private static Pluginbase pluginbase = new Pluginbase();

    /**
     * Standard Kontostand
     * Setzt einem Spieler in der Datenbank den standardmäßigen Kontostand von 1000.00.
     * @param player Spieler, dessen Kontostand gesetzt werden soll
     */
    public static void storeDefaultBalance(@NotNull Player player) {
        if (!ObjectSQLManager.objectExists(player)) {
            System.err.println("[Datenbank - LiquidPlayers] Kontostand konnte nicht aktualisiert werden! Spieler konnte nicht in der Datenbank gefunden werden.");
        } else {
            int id = ObjectSQLManager.getObjectId(player);
            ResultSet resultSet = MySQLAPI.query("SELECT `ReadyCash` FROM `LiquidPlayers` WHERE `ID` = \"" + id + "\";");

            try {
                if(resultSet.next()) {
                    MySQLAPI.update("UPDATE `LiquidPlayers` SET `ReadyCash`='" + 1000.00 + "' WHERE `ID`='" + id + "';");
                } else {
                    MySQLAPI.update("INSERT INTO `LiquidPlayers` (`UUID`, `Name`, `ReadyCash`) VALUES ('" +
                            player.getUniqueId().toString() + "','" + player.getName() + "','" + 1000.00 + "');");
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }

    /**
     * Bargeld setzen
     * Setzt das Bargeld eines Spielers auf einen bestimmten Wert.
     * @param player Spieler, dessen Kontostand gesetzt werden soll
     * @param balance Menge an Bargeld, die gesetzt werden soll
     */
    public static void storeBalance(@NotNull Player player, double balance) {
        if (!ObjectSQLManager.objectExists(player)) {
            System.err.println("[Datenbank - LiquidPlayers] Kontostand konnte nicht aktualisiert werden! Spieler konnte nicht in der Datenbank gefunden werden.");
        } else {
            int id = ObjectSQLManager.getObjectId(player);
            ResultSet resultSet = MySQLAPI.query("SELECT `ReadyCash` FROM `LiquidPlayers` WHERE `ID` = \"" + id + "\";");

            try {
                if (resultSet.next()) {
                    MySQLAPI.update("UPDATE `LiquidPlayers` SET `ReadyCash`='" + balance + "' WHERE `ID`='" + id + "';");
                } else {
                    MySQLAPI.update("INSERT INTO `LiquidPlayers` (`UUID`, `Name`, `ReadyCash`) VALUES ('" +
                            player.getUniqueId().toString() + "','" + player.getName() + "','" + balance + "');");
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        }
    }

    /**
     * Bargeld Anzeigen
     * Zeigt den Bargeldstand eines Spielers aus der Datenbank an.
     * @param player Spieler, dessen Bargeldstand angezeigt werden soll
     * @return Menge an Bargeld des angegebenen Spielers
     */
    public static double getPlayerBalance(Player player) {
        double balance = 1.00;

        try {
            int id = ObjectSQLManager.getObjectId(player);
            ResultSet resultSet = MySQLAPI.query("SELECT `ReadyCash` FROM `LiquidPlayers` WHERE `ID` = \"" + id + "\";");

            while (resultSet.next()) {
                balance = resultSet.getDouble("ReadyCash");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return balance;
    }
}

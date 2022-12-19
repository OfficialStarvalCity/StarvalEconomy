package de.starvalcity.starvaleconomy.database;

import de.starvalcity.base.api.def.database.MySQLAPI;
import de.starvalcity.base.api.def.economy.Bank;
import de.starvalcity.base.api.handling.object.ObjectSQLManager;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BackendHandler {

    /**
     * Standard Kontostand
     * Setzt einem Spieler in der Datenbank den standardmäßigen Kontostand von 1000.00.
     * @param player Spieler, dessen Kontostand gesetzt werden soll
     */
    public void storeDefaultBalance(@NotNull Player player) {
        if (!ObjectSQLManager.objectExists(player)) {
            System.err.println("[Spieler-Datenbank] Kontostand konnte nicht aktualisiert werden! Spieler konnte nicht in der Datenbank gefunden werden.");
        } else {
            int id = ObjectSQLManager.getObjectId(player);
            ResultSet resultSet = MySQLAPI.query("SELECT `Bargeld` FROM `Spieler` WHERE `ID` = \"" + id + "\";");

            try {
                if(resultSet.next()) {
                    MySQLAPI.update("UPDATE `Spieler` SET `Bargeld`='" + 1000.00 + "' WHERE `ID`='" + id + "';");
                } else {
                    MySQLAPI.update("INSERT INTO `Spieler` (`UUID`, `Name`, `Bargeld`) VALUES ('" +
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
    public void storeBalance(@NotNull Player player, double balance) {
        if (!ObjectSQLManager.objectExists(player)) {
            System.err.println("[Spieler-Datenbank] Kontostand konnte nicht aktualisiert werden! Spieler konnte nicht in der Datenbank gefunden werden.");
        } else {
            int id = ObjectSQLManager.getObjectId(player);
            ResultSet resultSet = MySQLAPI.query("SELECT `Bargeld` FROM `Spieler` WHERE `ID` = \"" + id + "\";");

            try {
                if (resultSet.next()) {
                    MySQLAPI.update("UPDATE `Spieler` SET `Bargeld`='" + balance + "' WHERE `ID`='" + id + "';");
                } else {
                    MySQLAPI.update("INSERT INTO `Spieler` (`UUID`, `Name`, `Bargeld`) VALUES ('" +
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
     * Geld Hinzufügung
     * Fügt einem Spieler eine Menge an Bargeld hinzu.
     * @param player Spieler
     * @param amount Menge an Bargeld
     */
    public void addBalance(@NotNull Player player, double amount) {
        if (!ObjectSQLManager.objectExists(player)) {
            System.err.println("[Spieler-Datenbank] Kontostand konnte nicht aktualisiert werden! Spieler konnte nicht in der Datenbank gefunden werden.");
        } else {
            int id = ObjectSQLManager.getObjectId(player);
            ResultSet resultSet = MySQLAPI.query("SELECT `Bargeld` FROM `Spieler` WHERE `ID` = \"" + id + "\";");

            double newBalance = getPlayerBalance(player) + amount;

            try {
                if (resultSet.next()) {
                    MySQLAPI.update("UPDATE `Spieler` SET `Bargeld`='" + newBalance + "' WHERE `ID`='" + id + "';");
                } else {
                    MySQLAPI.update("INSERT INTO `Spieler` (`UUID`, `Name`, `Bargeld`) VALUES ('" +
                            player.getUniqueId().toString() + "','" + player.getName() + "','" + newBalance + "');");
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
     * Geld Entfernung
     * Entfernt einem Spieler eine Menge an Bargeld.
     * @param player Spieler
     * @param amount Menge an Bargeld
     */
    public void removeBalance(@NotNull Player player, double amount) {
        if (!ObjectSQLManager.objectExists(player)) {
            System.err.println("[Spieler-Datenbank] Kontostand konnte nicht aktualisiert werden! Spieler konnte nicht in der Datenbank gefunden werden.");
        } else {
            int id = ObjectSQLManager.getObjectId(player);
            ResultSet resultSet = MySQLAPI.query("SELECT `Bargeld` FROM `Spieler` WHERE `ID` = \"" + id + "\";");

            double newBalance = getPlayerBalance(player) - amount;

            try {
                if (resultSet.next()) {
                    MySQLAPI.update("UPDATE `Spieler` SET `Bargeld`='" + newBalance + "' WHERE `ID`='" + id + "';");
                } else {
                    MySQLAPI.update("INSERT INTO `Spieler` (`UUID`, `Name`, `Bargeld`) VALUES ('" +
                            player.getUniqueId().toString() + "','" + player.getName() + "','" + newBalance + "');");
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
    public double getPlayerBalance(Player player) {
        double balance = 1.00;

        try {
            int id = ObjectSQLManager.getObjectId(player);
            ResultSet resultSet = MySQLAPI.query("SELECT `Bargeld` FROM `Spieler` WHERE `ID` = \"" + id + "\";");

            while (resultSet.next()) {
                balance = resultSet.getDouble("Bargeld");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return balance;
    }

    public void createBank(Bank bank) {
        if (!ObjectSQLManager.objectExists(bank)) {
            return;
        }
        if (ObjectSQLManager.objectExists(bank)) {

        }
    }
}

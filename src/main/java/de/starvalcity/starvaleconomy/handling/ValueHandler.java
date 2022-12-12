package de.starvalcity.starvaleconomy.handling;

import de.starvalcity.starvaleconomy.Corebase;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ValueHandler {

    private static Corebase corebase = new Corebase();

    /**
     * Mengenüberprüfung
     * Überprüft, ob ein Spieler für eine bestimmte Aktion genug Geld hat.
     * @param player Spieler
     * @param requiredAmount Benötigte Menge an Geld
     * @return true / false
     */
    public boolean hasEnoughMoney(@NotNull Player player, double requiredAmount) {
        return !(requiredAmount > corebase.getBackendHandler().getPlayerBalance(player));
    }

}

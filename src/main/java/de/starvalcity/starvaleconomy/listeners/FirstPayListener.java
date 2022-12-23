package de.starvalcity.starvaleconomy.listeners;

import de.starvalcity.base.Pluginbase;
import de.starvalcity.base.api.handling.object.ObjectSQLManager;
import de.starvalcity.starvaleconomy.Corebase;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstPayListener implements Listener {

    private static Corebase corebase = new Corebase();
    private static Pluginbase pluginbase = new Pluginbase();

    final TextComponent infoMessage = Component.text("Dein Geld wurde auf den Standardwert gesetzt!")
            .color(TextColor.color(0x227D00))
            .clickEvent(ClickEvent.runCommand("/money"))
            .hoverEvent(HoverEvent.showText(Component.text("Klicke, um dein Bargeld anzuzeigen!")
                    .color(TextColor.color(0xFFED00))));

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent event) {
        Player newbie = event.getPlayer();

        if (!ObjectSQLManager.objectExists(newbie)) {
            corebase.getBackendHandler().storeDefaultBalance(newbie);
            pluginbase.getLogHandler().sqlInfo("[DB-Spieler] Der Kontostand von " + newbie.getName() + " wurde auf den " +
                    "Standardwert gesetzt!");
            newbie.sendMessage(infoMessage);
        }
    }
}

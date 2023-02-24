package de.starvalcity.starvaleconomy.listeners;

import de.starvalcity.starvaleconomy.handling.ATMHandler;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class SignClickListener implements Listener {

    static Component atmSignLine = Component.text().content("[SCB - Automat]").color(TextColor.color(0x227D00)).build();

    public static Material[] signMaterials = ATMHandler.atmMaterials;

    @EventHandler
    public void onInteract(@NotNull PlayerInteractEvent interactEvent) {

        if (interactEvent.getClickedBlock().getState() instanceof Sign) {
            if (interactEvent.getAction()
                    ==
                    Action.RIGHT_CLICK_BLOCK
                    &&
                    Arrays.<Material>asList(signMaterials).contains(interactEvent.getClickedBlock().getType())) {

                Block block = interactEvent.getClickedBlock();

                if (!(block.getState() instanceof Sign)) return;

                Sign sign = (Sign) block.getState();

                if (sign.line(0).equals(atmSignLine)) {

                    interactEvent.getPlayer().sendMessage("Hi!");

                }
            }
        }

    }
}

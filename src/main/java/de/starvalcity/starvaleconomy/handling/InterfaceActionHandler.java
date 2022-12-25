package de.starvalcity.starvaleconomy.handling;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InterfaceActionHandler implements Listener {

    static Component guiTitle = Component.text().content("PayDay Dashboard").color(TextColor.color(0xD57119)).build();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent clickEvent) {
        Player player = (Player) clickEvent.getWhoClicked();
        ItemStack clickedItem = clickEvent.getCurrentItem();

        if (player.getOpenInventory().title().equals(guiTitle)) {
            switch (clickedItem.getType()) {
                case BLACK_STAINED_GLASS_PANE:
                    clickEvent.setCancelled(true);
                    break;
                case BARRIER:
                    player.closeInventory();
                    clickEvent.setCancelled(true);
                    break;
                case GREEN_WOOL:
                    player.performCommand("/payday resume");
                    player.closeInventory();
                    break;
                case RED_WOOL:
                    player.performCommand("/payday stop");
                    player.closeInventory();
                    break;
                case CLOCK:
                    // TODO
                    break;
                case GOLD_INGOT:
                    // TODO
                    break;
                case NETHER_STAR:
                    // TODO
                    break;
            }
            clickEvent.setCancelled(true);
        }
    }
}

package de.starvalcity.starvaleconomy.handling;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class InterfaceHandler {

    private final Inventory ADMIN_payDayGUI = Bukkit.createInventory(null, 54); // TODO: Title

    final TextComponent ADMIN_payDayGUI_title = Component.text()
            .content("PayDay Übersicht")
            .color(TextColor.color(0xFF7B00)).build();

    final TextComponent placeholderName = Component.text().content("").build();
    final TextComponent exitButtonName = Component.text().content("Schließen").color(TextColor.color(0xFF3D3C)).build();

    /**
     * Admin Dashboard - PayDay
     * @param player Spieler, der das GUI öffnet
     */
    public void openAdminPayDayGUI(@NotNull Player player) { // TODO: Content & Interactions

        ItemStack placeholder = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta placeholderMeta = placeholder.getItemMeta();
        placeholderMeta.displayName().append(placeholderName);
        placeholder.setItemMeta(placeholderMeta);

        ItemStack air = new ItemStack(Material.AIR);

        ItemStack exitButton = new ItemStack(Material.BARRIER);
        ItemMeta exitMeta = exitButton.getItemMeta();
        exitMeta.displayName().append(exitButtonName);
        exitButton.setItemMeta(exitMeta);

        ItemStack[] guiContents = {};
        ADMIN_payDayGUI.setContents(guiContents);

        player.openInventory(ADMIN_payDayGUI);
    }
}

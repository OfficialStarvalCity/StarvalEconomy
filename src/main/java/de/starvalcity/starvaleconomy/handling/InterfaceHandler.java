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

    static Inventory ADMIN_payDayGUI = Bukkit.createInventory(null, 27, "PayDay Übersicht"); // TODO: Title

    static TextComponent placeholderName = Component.text().content("").build();
    static TextComponent exitButtonName = Component.text().content("Schließen").color(TextColor.color(0xFF3D3C)).build();
    static TextComponent payDayStartName = Component.text().content("PayDay Starten").color(TextColor.color(0x2EDE00)).build();
    static TextComponent payDayPauseName = Component.text().content("PayDay Pausieren").color(TextColor.color(0xDEDB00)).build();
    static TextComponent remainingTimeName = Component.text().content("Verbleibende Zeit").color(TextColor.color(0xC2DE)).build();
    static TextComponent payDaySalaryName = Component.text().content("Auszahlung").color(TextColor.color(0xFF00FE)).build();
    static TextComponent payDayBonusName = Component.text().content("Bonus").color(TextColor.color(0xFF6B00)).build();

    /**
     * Admin Dashboard - PayDay
     * @param player Spieler, der das GUI öffnet
     */
    public static void openAdminPayDayGUI(@NotNull Player player) {

        // Platzhalter
        ItemStack placeholder = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta placeholderMeta = placeholder.getItemMeta();
        placeholder.displayName().append(placeholderName);
        placeholder.setItemMeta(placeholderMeta);

        // Leer
        ItemStack air = new ItemStack(Material.AIR);

        // Schließknopf
        ItemStack exitButton = new ItemStack(Material.BARRIER);
        ItemMeta exitMeta = exitButton.getItemMeta();
        exitButton.displayName().append(exitButtonName);
        exitButton.setItemMeta(exitMeta);

        // Start
        ItemStack payDayStart = new ItemStack(Material.GREEN_WOOL);
        ItemMeta payDayStartMeta = payDayStart.getItemMeta();
        payDayStart.displayName().append(payDayStartName);
        payDayStart.setItemMeta(payDayStartMeta);

        // Pausierung
        ItemStack payDayPause = new ItemStack(Material.RED_WOOL);
        ItemMeta payDayPauseMeta = payDayPause.getItemMeta();
        payDayPause.displayName().append(payDayPauseName);
        payDayPause.setItemMeta(payDayPauseMeta);

        // Verbleibende Zeit
        ItemStack remainingTime = new ItemStack(Material.CLOCK);
        ItemMeta remainingTimeMeta = remainingTime.getItemMeta();
        remainingTime.displayName().append(remainingTimeName);
        remainingTime.setItemMeta(remainingTimeMeta);

        // Auszahlungsbetrag
        ItemStack payDaySalary = new ItemStack(Material.GOLD_INGOT);
        ItemMeta payDaySalaryMeta = payDaySalary.getItemMeta();
        payDaySalary.displayName().append(payDaySalaryName);
        payDaySalary.setItemMeta(payDaySalaryMeta);

        // Bonus
        ItemStack payDayBonus = new ItemStack(Material.NETHER_STAR);
        ItemMeta payDayBonusMeta = payDayBonus.getItemMeta();
        payDayBonus.displayName().append(payDayBonusName);
        payDayBonus.setItemMeta(payDayBonusMeta);

        ItemStack[] guiContents = {
                placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder,
                placeholder, air, payDayStart, payDayPause, remainingTime, payDaySalary, payDayBonus, air, placeholder,
                placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder
        };
        ADMIN_payDayGUI.setContents(guiContents);

        player.openInventory(ADMIN_payDayGUI);
    }
}

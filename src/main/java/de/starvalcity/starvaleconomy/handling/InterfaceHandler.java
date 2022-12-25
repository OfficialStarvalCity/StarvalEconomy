package de.starvalcity.starvaleconomy.handling;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class InterfaceHandler {

    static Component guiTitle = Component.text().content("PayDay Dashboard").color(TextColor.color(0xD57119)).build();
    static Component placeholderTitle = Component.text().content("").build();
    static Component exitButtonTitle = Component.text().content("Verlassen").color(TextColor.color(0xFF3D3C)).build();
    static Component resumeTitle = Component.text().content("Starten").color(TextColor.color(0x227D00)).build();
    static Component pauseTitle = Component.text().content("Pausieren").color(TextColor.color(0xDE0089)).build();
    static Component remainingTimeTitle = Component.text().content("Verbleibende Zeit").color(TextColor.color(0xDECC48)).build();
    static Component salaryTitle = Component.text().content("Auszahlung").color(TextColor.color(0x40DE00)).build();
    static Component bonusTitle = Component.text().content("Bonus").color(TextColor.color(0xFFED00)).build();

    static Inventory ADMIN_payDayGUI = Bukkit.createInventory(null, 27, guiTitle);

    /**
     * Admin Dashboard - PayDay
     * @param player Spieler, der das GUI öffnet
     */
    public static void openAdminPayDayGUI(@NotNull Player player) {

        ItemStack placeholder = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta placeholderMeta = placeholder.getItemMeta();
        placeholderMeta.displayName(placeholderTitle);
        placeholder.setItemMeta(placeholderMeta);

        ItemStack air = new ItemStack(Material.AIR);

        ItemStack exitButton = new ItemStack(Material.BARRIER);
        ItemMeta exitButtonMeta = exitButton.getItemMeta();
        exitButtonMeta.displayName(exitButtonTitle);
        exitButton.setItemMeta(exitButtonMeta);

        ItemStack resume = new ItemStack(Material.GREEN_WOOL);
        ItemMeta resumeMeta = resume.getItemMeta();
        resumeMeta.displayName(resumeTitle);
        resume.setItemMeta(resumeMeta);

        ItemStack pause = new ItemStack(Material.RED_WOOL);
        ItemMeta pauseMeta = pause.getItemMeta();
        pauseMeta.displayName(pauseTitle);
        pause.setItemMeta(pauseMeta);

        ItemStack remainingTime = new ItemStack(Material.CLOCK);
        ItemMeta remainingTimeMeta = remainingTime.getItemMeta();
        remainingTimeMeta.displayName(remainingTimeTitle);
        remainingTime.setItemMeta(remainingTimeMeta);

        ItemStack salary = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta salaryMeta = salary.getItemMeta();
        salaryMeta.displayName(salaryTitle);
        salary.setItemMeta(salaryMeta);

        ItemStack bonus = new ItemStack(Material.NETHER_STAR);
        ItemMeta bonusMeta = bonus.getItemMeta();
        bonusMeta.displayName(bonusTitle);
        bonus.setItemMeta(bonusMeta);

        // First Row
        ADMIN_payDayGUI.setItem(0, placeholder);
        ADMIN_payDayGUI.setItem(1, placeholder);
        ADMIN_payDayGUI.setItem(2, placeholder);
        ADMIN_payDayGUI.setItem(3, placeholder);
        ADMIN_payDayGUI.setItem(4, placeholder);
        ADMIN_payDayGUI.setItem(5, placeholder);
        ADMIN_payDayGUI.setItem(6, placeholder);
        ADMIN_payDayGUI.setItem(7, placeholder);
        ADMIN_payDayGUI.setItem(8, exitButton);

        // Second Row
        ADMIN_payDayGUI.setItem(9, placeholder);
        ADMIN_payDayGUI.setItem(10, air);
        ADMIN_payDayGUI.setItem(11, resume);
        ADMIN_payDayGUI.setItem(12, pause);
        ADMIN_payDayGUI.setItem(13, remainingTime);
        ADMIN_payDayGUI.setItem(14, salary);
        ADMIN_payDayGUI.setItem(15, bonus);
        ADMIN_payDayGUI.setItem(16, air);
        ADMIN_payDayGUI.setItem(17, placeholder);

        // Third Row
        ADMIN_payDayGUI.setItem(18, placeholder);
        ADMIN_payDayGUI.setItem(19, placeholder);
        ADMIN_payDayGUI.setItem(20, placeholder);
        ADMIN_payDayGUI.setItem(21, placeholder);
        ADMIN_payDayGUI.setItem(22, placeholder);
        ADMIN_payDayGUI.setItem(23, placeholder);
        ADMIN_payDayGUI.setItem(24, placeholder);
        ADMIN_payDayGUI.setItem(25, placeholder);
        ADMIN_payDayGUI.setItem(26, placeholder);

        player.openInventory(ADMIN_payDayGUI);
    }
}

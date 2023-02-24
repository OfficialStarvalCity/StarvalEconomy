package de.starvalcity.starvaleconomy.handling;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ATMHandler {

    static Component atmSignLine = Component.text().content("[SCB - Automat]").color(TextColor.color(0x227D00)).build();

    public static Material[] atmMaterials = new Material[] {
            Material.OAK_WALL_SIGN
    };

    public void createATM(@NotNull Player atmSetter) {

        // Quartz Block
        Location loc = atmSetter.getLocation().getBlock().getRelative(BlockFace.SELF).getLocation();
        loc.getWorld().getBlockAt(loc).setType(Material.QUARTZ_BLOCK);

        // Quartz Stairs
        Location loc2 = atmSetter.getLocation().getBlock().getRelative(BlockFace.SELF).getLocation().add(0,1,0);
        loc2.getWorld().getBlockAt(loc2).setType(Material.QUARTZ_STAIRS);

        // Sign
        Location loc3 = atmSetter.getLocation().getBlock().getRelative(BlockFace.SELF).getLocation().add(0, 1, -1);
        loc3.getWorld().getBlockAt(loc3).setType(Material.OAK_WALL_SIGN);

        // Sign Line
        Sign sign = (Sign) loc3.getBlock().getState();
        sign.line(0, atmSignLine);
        sign.update();
    }
}

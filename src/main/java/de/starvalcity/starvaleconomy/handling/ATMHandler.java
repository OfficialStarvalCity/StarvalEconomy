package de.starvalcity.starvaleconomy.handling;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ATMHandler {

    public static Material[] atmMaterials = new Material[] {
            Material.OAK_SIGN,
            Material.OAK_WALL_SIGN
    };

    public void createATM(@NotNull Player player) {

        World playerWorld = player.getWorld();

        double playerLocationX = player.getLocation().getX();
        double playerLocationY = player.getLocation().getY();
        double playerLocationZ = player.getLocation().getZ();

        double playerLocationY2 = player.getLocation().getY() + 1;

        Location playerLoc = new Location(playerWorld, playerLocationX, playerLocationY, playerLocationZ);
        Location playerLoc2 = new Location(playerWorld, playerLocationX, playerLocationY2, playerLocationZ);

        playerLoc.getBlock().setType(Material.QUARTZ_BLOCK);
        playerLoc2.getBlock().setType(Material.QUARTZ_STAIRS);
    }

}

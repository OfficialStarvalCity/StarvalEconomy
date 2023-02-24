package de.starvalcity.starvaleconomy.def;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.Material;

@Getter @Setter
public class ATM {

    private int id;
    private String name;
    private Object owner;
    private Material signMaterial;
    private Location location;

    public ATM(String name, Object owner, Material signMaterial, Location location) {
        this.name = name;
        this.owner = owner;
        this.signMaterial = signMaterial;
        this.location = location;
    }

}

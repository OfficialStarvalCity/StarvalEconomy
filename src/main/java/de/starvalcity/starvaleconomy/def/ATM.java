package de.starvalcity.starvaleconomy.def;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;

@Getter @Setter
public class ATM {

    private int id;
    private String name;
    private Object owner;
    private Material signMaterial;

    public ATM(String name, Object owner, Material signMaterial) {
        this.name = name;
        this.owner = owner;
        this.signMaterial = signMaterial;
    }

}

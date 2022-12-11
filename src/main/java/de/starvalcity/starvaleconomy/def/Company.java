package de.starvalcity.starvaleconomy.def;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter @Setter
public class Company {

    private int companyId;
    private String companyName;
    private UUID companyHolder;
    private List<UUID> workers;

    public Company(int companyId, String companyName, UUID companyHolder) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyHolder = companyHolder;
    }

}

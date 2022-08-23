package at.imbussstation.starvalcity_economy.handler.balance;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Balance {
    private final UUID uuid;
    private double balance;

    public Balance(UUID uuid, double balance) {
        this.uuid = uuid;
        this.balance = balance;
    }
}

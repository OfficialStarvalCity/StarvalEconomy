package de.starvalcity.starvaleconomy.def;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class ReadyCash {

    private int cashId;
    private UUID cashHolder;
    private int balance;

    public ReadyCash(UUID cashHolder, int balance) {
        this.cashHolder = cashHolder;
        this.balance = balance;
    }

}

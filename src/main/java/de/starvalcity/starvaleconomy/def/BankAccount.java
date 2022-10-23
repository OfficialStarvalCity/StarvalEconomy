package de.starvalcity.starvaleconomy.def;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

@Getter @Setter
public class BankAccount {

    private int accountId;
    private String accountName;
    private UUID accountHolder;
    private BankAccountType accountType;
    private @Nullable List<UUID> members;
    private @Nullable List<UUID> moderators;
    private double balance;

     public BankAccount(int accountId, String accountName, UUID accountHolder, BankAccountType accountType) {
         this.accountId = accountId;
         this.accountName = accountName;
         this.accountHolder = accountHolder;
         this.accountType = accountType;
     }
}

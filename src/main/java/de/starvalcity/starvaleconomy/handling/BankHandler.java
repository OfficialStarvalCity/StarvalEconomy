package de.starvalcity.starvaleconomy.handling;

import de.starvalcity.base.api.def.economy.Bank;
import de.starvalcity.base.api.handling.object.ObjectSQLManager;

public class BankHandler {

    public void createBank(String name) {
        Bank bank = new Bank(name, null, null);

        if (ObjectSQLManager.objectExists(bank)) {
            return;
        }
        if (!ObjectSQLManager.objectExists(bank)) {
            ObjectSQLManager.attachObject(bank);

        }
    }

}

package de.starvalcity.starvaleconomy.handling;

import de.starvalcity.base.api.def.StarvalPlayer;
import de.starvalcity.starvaleconomy.def.CashType;

public class CashHandler {

    public void setDefaultAmount(StarvalPlayer target, CashType cashType) {

        switch (cashType) {
            case READY_CASH:
                target.setReadyCash(1000.00);
                break;
            case BANK_ACCOUNT_CASH:

        }

    }

}

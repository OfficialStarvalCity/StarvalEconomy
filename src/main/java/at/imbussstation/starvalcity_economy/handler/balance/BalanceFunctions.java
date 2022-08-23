package at.imbussstation.starvalcity_economy.handler.balance;

import java.text.DecimalFormat;
import java.util.UUID;

public class BalanceFunctions {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static double getBalance(UUID uuid) {
        if (!BalanceHandler.BALANCE_HOLDER.containsKey(uuid))
            return 0;
        return Double.parseDouble(df.format(BalanceHandler.BALANCE_HOLDER.get(uuid).getBalance()));
    }

    public static void setBalance(UUID uuid, double balance) {
        if (!BalanceHandler.BALANCE_HOLDER.containsKey(uuid))
            return;
        balance = Double.parseDouble(df.format(balance));
        BalanceHandler.BALANCE_HOLDER.get(uuid).setBalance(balance);
    }

    public static void addBalance(UUID uuid, double balance) {
        if (!BalanceHandler.BALANCE_HOLDER.containsKey(uuid))
            return;
        balance = Double.parseDouble(df.format(balance));
        BalanceHandler.BALANCE_HOLDER.get(uuid).setBalance(getBalance(uuid) + balance);
    }

    public static void removeBalance(UUID uuid, double balance) {
        if (!BalanceHandler.BALANCE_HOLDER.containsKey(uuid))
            return;
        balance = Double.parseDouble(df.format(balance));
        BalanceHandler.BALANCE_HOLDER.get(uuid).setBalance(getBalance(uuid) - balance);
    }

    public static boolean hasBalance(UUID uuid, double balance) {
        if (!BalanceHandler.BALANCE_HOLDER.containsKey(uuid))
            return false;
        balance = Double.parseDouble(df.format(balance));
        return getBalance(uuid) >= balance;
    }


}

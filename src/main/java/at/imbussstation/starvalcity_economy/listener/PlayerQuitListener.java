package at.imbussstation.starvalcity_economy.listener;

import at.imbussstation.starvalcity_economy.handler.balance.BalanceHandler;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerQuitListener implements Listener {
    private JavaPlugin javaPlugin;
    private BalanceHandler balanceHandler;

    public PlayerQuitListener(JavaPlugin javaPlugin, BalanceHandler balanceHandler) {
        Bukkit.getPluginManager().registerEvents(this, javaPlugin);
        this.javaPlugin = javaPlugin;
        this.balanceHandler = balanceHandler;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        balanceHandler.saveToDatabase(BalanceHandler.BALANCE_HOLDER.get(event.getPlayer().getUniqueId()));
    }


}

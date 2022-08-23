package at.imbussstation.starvalcity_economy.listener;

import at.imbussstation.starvalcity_economy.handler.balance.BalanceHandler;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerJoinListener implements Listener {
    private JavaPlugin javaPlugin;
    private BalanceHandler balanceHandler;

    public PlayerJoinListener(JavaPlugin javaPlugin, BalanceHandler balanceHandler) {
        Bukkit.getPluginManager().registerEvents(this, javaPlugin);
        this.javaPlugin = javaPlugin;
        this.balanceHandler = balanceHandler;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        balanceHandler.loadFromDatabase(event.getPlayer().getUniqueId());
    }




}
package de.starvalcity.starvaleconomy.handling;

import de.starvalcity.starvaleconomy.Core;
import de.starvalcity.starvaleconomy.Corebase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class PayDayHandler {

    private static Corebase corebase = new Corebase();

    private static final int DEFAULT_INTERVAL = 60;
    private int interval = DEFAULT_INTERVAL;

    private boolean running = false;

    private BukkitRunnable task;

    public void startPayDay() {
        if (!running) {
            running = true;
            task = new BukkitRunnable() {

                @Override
                public void run() {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        corebase.getBackendHandler().addBalance(player, 200);
                        player.sendMessage("PayDay! Du hast dein Geld erhalten!");
                        task.runTaskTimer(JavaPlugin.getPlugin(Core.class), 0, interval * 20);
                    }
                }
            };
        }
    }

    public void stopPayDay() {
        if (running) {
            running = false;
            task.cancel();
        }
    }

    public void setInterval(int newInterval) {
        if (running) {
            task.cancel();
            interval = newInterval;
            task = new BukkitRunnable() {
                public void run() {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        corebase.getBackendHandler().addBalance(player, 200);
                        player.sendMessage("PayDay! Du hast dein Geld erhalten!");
                    }
                }
            };
            task.runTaskTimer(JavaPlugin.getPlugin(Core.class), 0, interval * 20);
        } else {
            interval = newInterval;
        }
    }

    public void resumePayDay() {
        if (!running) {
            running = true;
            task = new BukkitRunnable() {
                public void run() {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        corebase.getBackendHandler().addBalance(player, 200);
                        player.sendMessage("PayDay! Du hast dein Geld erhalten!");
                    }
                }
            };
            task.runTaskTimer(JavaPlugin.getPlugin(Core.class), 0, interval * 20);
        }
    }
}

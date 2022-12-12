package de.starvalcity.starvaleconomy.commands;

import de.starvalcity.base.api.handling.MessageManager;
import de.starvalcity.starvaleconomy.Core;
import de.starvalcity.starvaleconomy.Corebase;
import de.starvalcity.starvaleconomy.database.BackendHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MoneyCommand implements CommandExecutor {

    private final Corebase core = new Corebase();
    private final MessageManager msg = new MessageManager();

    private static Core plugin;

    public MoneyCommand(Core plugin) {
        this.plugin = plugin;
    }

    private String commandPermission = "economy.showmoney.own";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage(msg.getMessage("Spielerbefehl!"));
        }
        if (sender instanceof Player) {

            Player player = (Player) sender;

            // /money
            if (args.length == 0) {

                if (!player.hasPermission(commandPermission)) {

                    player.sendMessage(msg.getMessage("General.Insufficient_Permissions"));

                }
                if (player.hasPermission(commandPermission)) {

                    player.sendMessage("Dein Kontostand: " + core.getBackendHandler().getPlayerBalance(player));
                }
            }

            // /money setdefault <Spielername>
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("setdefault")) {
                    Player target = Bukkit.getPlayer(args[1]);

                    if (target != null) {

                        core.getBackendHandler().storeDefaultBalance(player);
                    }
                }
            }

            // /money pay <Spielername> <Anzahl>
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("pay")) {
                    Player target = Bukkit.getPlayer(args[1]);

                    if (target != null) {

                        try {
                            double amount = Double.parseDouble(args[2]);

                            if (!core.getValueHandler().hasEnoughMoney(player, amount)) {
                                player.sendMessage("Nicht genug Geld!");
                            } else {

                                core.getBackendHandler().addBalance(target, amount);
                                core.getBackendHandler().removeBalance(player, amount);
                            }
                        } catch (NumberFormatException numberFormatException) {
                            numberFormatException.printStackTrace();
                            player.sendMessage("Kein Double!");
                        }
                    }
                }
            }

            // /money set <Spielername> <Anzahl>
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("set")) {
                    Player target = Bukkit.getPlayer(args[1]);

                    if (target != null) {

                        try {
                            double amount = Double.parseDouble(args[2]);
                            core.getBackendHandler().storeBalance(target, amount);
                        } catch (NumberFormatException numberFormatException) {
                            numberFormatException.printStackTrace();
                            player.sendMessage("Kein Double!");
                        }
                    }
                }
            }

        }

        return true;
    }
}

package de.starvalcity.starvaleconomy.commands;

import de.starvalcity.starvaleconomy.Core;
import de.starvalcity.starvaleconomy.Corebase;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ATMCommand implements CommandExecutor {

    private static Corebase corebase = new Corebase();

    private Core plugin;

    public ATMCommand(Core plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player sender = (Player) commandSender;

        if (strings.length == 0) {
            corebase.getAtmHandler().createATM(sender);
        }

        if (strings.length == 2) {

        }

        return false;
    }
}

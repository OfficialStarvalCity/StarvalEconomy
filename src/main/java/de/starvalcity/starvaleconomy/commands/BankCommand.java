package de.starvalcity.starvaleconomy.commands;

import de.starvalcity.starvaleconomy.Core;
import de.starvalcity.starvaleconomy.Corebase;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BankCommand implements CommandExecutor {

    private static Corebase corebase = new Corebase();

    private Core plugin;

    public BankCommand(Core plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            // /bank create <Name>
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("create")) {

                    String name = args[1];
                }
            }
        }
        return false;
    }
}

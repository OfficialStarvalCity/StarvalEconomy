package at.imbussstation.starvalcity_economy.commands;

import at.imbussstation.starvalcity_economy.Functions;
import at.imbussstation.starvalcity_economy.enums.Message;
import at.imbussstation.starvalcity_economy.enums.Permission;
import at.imbussstation.starvalcity_economy.handler.balance.BalanceFunctions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Eco_CMD implements CommandExecutor {

    public Eco_CMD(JavaPlugin plugin, String cmd) {
        plugin.getCommand(cmd).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission(Permission.ECO_CMD.value())) {
            sender.sendMessage(Message.NO_PERMISSION.value());
            return false;
        }

        if (args.length == 0) {
            sender.sendMessage(Message.USAGE.value());
        } else if (args.length == 2) {
            String targetname = args[1];
            Player target = Bukkit.getPlayer(targetname);
            if (target == null) {
                sender.sendMessage(Message.NO_PLAYER_FOUND.value());
                return false;
            }

            if (args[0].equalsIgnoreCase("get")) {
                sender.sendMessage(Functions.formatter(Message.BALANCE_GET.value(), targetname, BalanceFunctions.getBalance(target.getUniqueId()) + ""));
            }
        } else if (args.length == 3) {
            String targetname = args[1];
            Player target = Bukkit.getPlayer(targetname);
            if (target == null) {
                sender.sendMessage(Message.NO_PLAYER_FOUND.value());
                return false;
            }

            double amount = 0;
            try {
                amount = Double.parseDouble(args[2]);
            } catch (NumberFormatException e) {
                sender.sendMessage(Message.NO_VALID_INPUT.value());
                return false;
            }

            if (args[0].equalsIgnoreCase("add")) {
                BalanceFunctions.addBalance(target.getUniqueId(), amount);
                sender.sendMessage(Functions.formatter(Message.BALANCE_ADDED.value(), targetname, args[2]));
            } else if (args[0].equalsIgnoreCase("set")) {
                BalanceFunctions.setBalance(target.getUniqueId(), amount);
                sender.sendMessage(Functions.formatter(Message.BALANCE_SET.value(), targetname, args[2]));
            } else if (args[0].equalsIgnoreCase("remove")) {
                BalanceFunctions.removeBalance(target.getUniqueId(), amount);
                sender.sendMessage(Functions.formatter(Message.BALANCE_REMOVED.value(), targetname, args[2]));
            } else {
                sender.sendMessage(Message.USAGE.value());
            }
        }
        return false;
    }
}

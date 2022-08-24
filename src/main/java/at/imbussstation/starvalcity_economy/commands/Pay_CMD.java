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

public class Pay_CMD implements CommandExecutor {

    public Pay_CMD(JavaPlugin plugin, String cmd) {
        plugin.getCommand(cmd).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Message.MUST_BE_A_PLAYER.value());
            return false;
        }

        Player player = (Player) sender;

        if(!player.hasPermission(Permission.PAY_CMD.value())) {
            player.sendMessage(Message.NO_PERMISSION.value());
            return false;
        }

        if(args.length == 2) {
            String targetname = args[0];
            Player target = Bukkit.getPlayer(targetname);
            if (target == null) {
                sender.sendMessage(Message.NO_PLAYER_FOUND.value());
                return false;
            }

            double amount = 0;
            try {
                amount = Double.parseDouble(args[1]);
            } catch (NumberFormatException e) {
                sender.sendMessage(Message.NO_VALID_INPUT.value());
                return false;
            }

            if(!BalanceFunctions.hasBalance(player.getUniqueId(), amount)) {
                player.sendMessage(Message.NOT_ENOUGH_MONEY.value());
                return false;
            }

            BalanceFunctions.removeBalance(player.getUniqueId(), amount);
            target.sendMessage(Functions.formatter(Message.PAID_TARGET.value(), player.getName(), amount + ""));
            BalanceFunctions.addBalance(target.getUniqueId(), amount);
            target.sendMessage(Functions.formatter(Message.PAID_TARGET.value(), amount + "", player.getName()));
        }

        return false;
    }
}

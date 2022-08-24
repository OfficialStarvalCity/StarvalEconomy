package at.imbussstation.starvalcity_economy.enums;

public enum Message {
    MUST_BE_A_PLAYER("§cYou must be a player to use this command!"),
    NO_PERMISSION("§cYou have no permission to use this command!"),
    NO_PLAYER_FOUND("§cNo player found with that name!"),
    USAGE("/eco <add/set/remove/get> <player> <amount>"),
    NO_VALID_INPUT("§cNo valid input!"),
    BALANCE_ADDED("§aSuccessfully added §e{0}§a to §e{1}§a!"),
    BALANCE_SET("§aSuccessfully set §e{0}'s §aBalance to §e{1}§a!"),
    BALANCE_REMOVED("§aSuccessfully removed §e{0}§a from §e{1}§a!"),
    BALANCE_GET("§aBalance of §e{0}§a is §e{1}§a!"),
    NOT_ENOUGH_MONEY("§cYou don't have enough Money!"),
    PAID_PLAYER("§aSuccessfully paid §e{0} §ato §e{1}'s§a!"),
    PAID_TARGET("§aYou got §e{0} §apaid from §e{1}§a!");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String value() {
        return message;
    }
}

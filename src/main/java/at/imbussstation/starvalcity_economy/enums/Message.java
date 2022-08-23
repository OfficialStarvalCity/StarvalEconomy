package at.imbussstation.starvalcity_economy.enums;

public enum Message {
    MUST_BE_A_PLAYER("&cYou must be a player to use this command!"),
    NO_PERMISSION("&cYou have no permission to use this command!"),
    NO_PLAYER_FOUND("&cNo player found with that name!"),
    USAGE("&cUsage: /eco <name>\n" + "/eco <add/set/remove/get> <player> <amount>"),
    NO_VALID_INPUT("&cNo valid input!"),
    BALANCE_ADDED("&aBalance added to &e{0}&a!"),
    BALANCE_SET("&aBalance set to &e{0}&a!"),
    BALANCE_REMOVED("&aBalance removed from &e{0}&a!"),
    BALANCE_GET("&aBalance of &e{0}&a is &e{1}&a!");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String value() {
        return message;
    }
}

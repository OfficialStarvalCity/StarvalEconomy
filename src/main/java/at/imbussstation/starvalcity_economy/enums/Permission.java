package at.imbussstation.starvalcity_economy.enums;

public enum Permission {
    ECO_CMD("starvalcity.economy.cmd");

    private String message;

    Permission(String message) {
        this.message = message;
    }

    public String value() {
        return message;
    }
}

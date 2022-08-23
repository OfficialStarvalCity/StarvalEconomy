package at.imbussstation.starvalcity_economy;

public class Functions {

   public static String formatter(String message, String... str) {
        String formated = message;
        for (int i = 0; i < str.length; i++) {
            formated = formated.replace("{" + i + "}", str[i]);
        }
        return formated;
    }

}

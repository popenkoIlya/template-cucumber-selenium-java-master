package cucumber.utils;

import java.util.Objects;

public class StringUtils {
    public static String getPreparedStringValue(String string){
        return string.replaceAll("\\s+","");
    }

    public static boolean compareMeaningStrings(String string1, String string2){
        return Objects.equals(getPreparedStringValue(string1),getPreparedStringValue(string2));
    }
}

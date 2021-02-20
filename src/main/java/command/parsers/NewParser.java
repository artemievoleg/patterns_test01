package command.parsers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NewParser {

    public static String parseClass(String commandline) {
        // parse command for class and fix case register (classname -> Classname)
        String lowercaseString = commandline.trim().toLowerCase();
        StringBuilder tempClassStr = new StringBuilder(lowercaseString.substring(0,lowercaseString.lastIndexOf(' ')));
        tempClassStr.setCharAt(0,tempClassStr.toString().toUpperCase().charAt(0));

        return tempClassStr.toString();
    }

    public static Map<String, String> parseParameters(String commandline) {
        String parametersLine = commandline.substring(commandline.indexOf(' ')).trim();

        Map<String, String> parameters = new HashMap<>();

        Arrays.stream(parametersLine.split("-")).forEach(str -> {
            if(str.matches(".*:.*\".*\".*")){
                String lowercaseString = str.trim().toLowerCase();
                StringBuilder tempKeyStr = new StringBuilder(lowercaseString.substring(0,lowercaseString.lastIndexOf(':')));
                tempKeyStr.setCharAt(0,tempKeyStr.toString().toUpperCase().charAt(0));

                String key = tempKeyStr.toString();
                String value = str.substring(str.indexOf('"') + 1, str.lastIndexOf('"'));

                parameters.put(key, value);
            }
        });

        return parameters;
    }
}

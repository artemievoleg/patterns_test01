package command.parsers;

public class ListParser {

    public static String parseClass(String commandline) {
        // parse command for class and fix case register (classname -> Classname)
        String lowercaseString = commandline.trim().toLowerCase();
        StringBuilder tempClassStr = new StringBuilder(lowercaseString.substring(0,lowercaseString.lastIndexOf(' ')));
        tempClassStr.setCharAt(0,tempClassStr.toString().toUpperCase().charAt(0));

        return tempClassStr.toString();
    }
}

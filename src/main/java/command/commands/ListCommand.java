package command.commands;

import command.parsers.ListParser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ListCommand extends Command {

    private static final String containerPackagePath = "containers";

    private Class objectSetClass;

    public ListCommand(String commandLine) {
        super(commandLine);
    }

    @Override
    public void execute(String commandLine) {

        String classString = ListParser.parseClass(commandLine);

        try {

            Class objectSetClass = Class.forName(containerPackagePath + "." + classString + "Set");
            this.objectSetClass = objectSetClass;

        } catch (ClassNotFoundException e) {
            System.out.println("Could not find classSet");
        }

        try {

            Method getSetMethod = objectSetClass.getDeclaredMethod("getSet");
            try {

                String outString = getSetMethod.invoke(null).toString();
                System.out.println(outString);

            } catch (IllegalAccessException e) {
                System.out.println("Could not access method getSet");
            } catch (InvocationTargetException e) {
                System.out.println("Could not invoke method getSet");
            }

        } catch (NoSuchMethodException e) {
            System.out.println("Could not find method getSet");
        }
    }

    @Override
    public void undo() {

    }
}

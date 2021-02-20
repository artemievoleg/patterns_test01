package command.commands;

import command.parsers.NewParser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class NewCommand extends Command {

    private static final String packagePath = "entities";
    private static final String containerPackagePath = "containers";

    private Class objectClass;
    private Object object;
    private Class objectSetClass;

    public NewCommand(String commandLine) {
        super(commandLine);
    }

    @Override
    public void execute(String commandLine) {
        String classString = NewParser.parseClass(commandLine);
        Map<String, String> parameters = NewParser.parseParameters(commandLine);

        Object object;
        try {
            this.objectClass = Class.forName(packagePath + "." + classString);
            object = objectClass.newInstance();
            this.object = object;

            parameters.forEach((str1, str2) -> {
                try {
                    Method method = objectClass.getDeclaredMethod("set" + str1,String.class);
                    method.invoke(object,str2);
                } catch (NoSuchMethodException e) {
                    System.out.println("Method not found exception.");
                } catch (InvocationTargetException | IllegalAccessException e) {
                    System.out.println("Method could not invoked exception.");
                }
            });

            System.out.println(object);

            Class objectSetClass = Class.forName(containerPackagePath + "." + classString + "Set");
            this.objectSetClass = objectSetClass;

            try {
                Method setAddMethod = objectSetClass.getDeclaredMethod("add", objectClass);
                setAddMethod.invoke(null, object);
            } catch (NoSuchMethodException e) {
                System.out.println("Could not add object into set.");
            } catch (InvocationTargetException e) {
                System.out.println("Could not add object into set.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Could not find class " + classString + " in package " + packagePath);
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Could not create object.");
        }
    }

    @Override
    public void undo() {

        try {
            Method setRemoveMethod = objectSetClass.getDeclaredMethod("remove", this.objectClass);
            setRemoveMethod.invoke(null, this.object);
        } catch (NoSuchMethodException e) {
            System.out.println("Could not remove object from set.");
        } catch (InvocationTargetException e) {
            System.out.println("Could not remove object from set.");
        } catch (IllegalAccessException e) {
            System.out.println("Could not remove object from set.");
        }
    }
}

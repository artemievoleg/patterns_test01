package command.commands;

import command.parsers.ListParser;
import containers.BookSet;

public class ListCommand extends Command {

    private static final String packagePath = "entities";
    private static final String containerPackagePath = "containers";

    private Class objectClass;
    private Object object;
    private Class objectSetClass;

    public ListCommand(String commandLine) {
        super(commandLine);
    }

    @Override
    public void execute(String commandLine) {

        String classString = ListParser.parseClass(commandLine);

        Object object;
        try {
            this.objectClass = Class.forName(packagePath + "." + classString);
            object = objectClass.newInstance();
            this.object = object;

            Class objectSetClass = Class.forName(containerPackagePath + "." + classString + "Set");
            this.objectSetClass = objectSetClass;

        } catch (ClassNotFoundException e) {
            System.out.println("Could not find class " + classString + " in package " + packagePath);
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Could not create object.");
        }



        BookSet.getSet().forEach(book -> System.out.println(book));



    }

    @Override
    public void undo() {

    }
}

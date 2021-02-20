package command;

import command.commands.Command;
import command.commands.ListCommand;
import command.commands.NewCommand;
import command.commands.UndoCommand;
import containers.BookSet;

import java.util.Scanner;

public class Invoker {

    public static void run() {

        Scanner scanner = new Scanner(System.in);

        String input = "";

        while (!"quit".equalsIgnoreCase(input)) {

            System.out.print("Enter command(type help for help): ");

            input = scanner.nextLine();
            String commandStr = input;
            String parametersStr = "";

            if(input.indexOf(' ') != -1) {
                commandStr = input.substring(0, input.indexOf(' '));
                parametersStr = input.substring(input.indexOf(' '));
            }

            switch (commandStr) {

                case "help":

                    System.out.println("Commands:\nhelp - for help\nquit - for exit\nlist - shows list of objects\nnew <ClassName> <FieldName>:\"<Value>\" <FieldName>:\"<Value>\" - for creating objects\nundo - undoing last operation");;

                    break;

                case "new":

                    Command newCommand = new NewCommand(input);
                    CommandHistory.push(newCommand);
                    newCommand.execute(parametersStr);

                    break;

                case "list":

                    Command listCommand = new ListCommand(input);
                    listCommand.execute(parametersStr);

                    break;

                case "undo":

                    Command undoCommand = new UndoCommand(input);
                    undoCommand.execute(parametersStr);

                    break;

                case "undolist":

                    CommandHistory.getList().forEach(System.out::println);

                    break;

                default:

                    System.out.println("Invalid command. Try again or type help for help.");
            }
        }

        System.out.println(BookSet.getSet());
        System.out.println("Bye!");
    }
}

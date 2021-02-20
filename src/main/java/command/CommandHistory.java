package command;

import command.commands.Command;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CommandHistory {

    private static LinkedList<Command> history = new LinkedList<>();

    public static void push(Command command) {
        history.push(command);
    }

    public static Command pop() {
        return history.peekLast();
    }

    public static Command element() {
        return history.element();
    }

    public static List<Command> getList() {
        return Collections.unmodifiableList(history);
    }
}

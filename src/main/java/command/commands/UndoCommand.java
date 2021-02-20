package command.commands;

import command.CommandHistory;

public class UndoCommand extends Command {

    public UndoCommand(String commandLine) {
        super(commandLine);
    }

    @Override
    public void execute(String commandLine) {

        Command command = CommandHistory.pop();

        if (command != null) {
            command.undo();
        } else {
            System.out.println("Nothing else to undo...");
        }
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Cannot invoke method undo in command undo...");
    }
}

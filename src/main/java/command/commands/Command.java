package command.commands;

public abstract class Command {

    protected final String commandString;

    public Command(String commandLine) {
        this.commandString = commandLine;
    }

    public abstract void execute(String commandLine);

    public abstract void undo();

    @Override
    public String toString() {
        return "Command{" +
                "commandString='" + commandString + '\'' +
                '}';
    }
}

package ru.tB.command;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("nocommand"),
    STAT("/stat");

    private final String CommandName;

    CommandName(String commandName) {
        this.CommandName = commandName;
    }

    public String getCommandName() {
        return CommandName;
    }
}

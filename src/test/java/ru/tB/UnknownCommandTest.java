package ru.tB;

import org.junit.jupiter.api.DisplayName;
import ru.tB.command.Command;
import ru.tB.command.UnknownCommand;

@DisplayName("Unit-level testing for UnknownCommand")
public class UnknownCommandTest extends  AbstractCommandTest {

    @Override
    String getCommandName() {
        return "/fgdfgfdhg";
    }

    @Override
    String getCommandMessage() {
        return UnknownCommand.UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}

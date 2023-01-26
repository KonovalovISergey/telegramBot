package ru.tB;

import org.junit.jupiter.api.DisplayName;
import ru.tB.command.Command;
import ru.tB.command.CommandName;
import ru.tB.command.NoCommand;

@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return CommandName.NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NoCommand.NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}

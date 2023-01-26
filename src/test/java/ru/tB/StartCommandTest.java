package ru.tB;

import org.junit.jupiter.api.DisplayName;
import ru.tB.command.Command;
import ru.tB.command.CommandName;
import ru.tB.command.StartCommand;

@DisplayName("Unit-level testing for StartCommand")
public class StartCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return CommandName.START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StartCommand.START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}

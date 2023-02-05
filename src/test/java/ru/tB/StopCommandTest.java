package ru.tB;

import org.junit.jupiter.api.DisplayName;
import ru.tB.command.Command;
import ru.tB.command.CommandName;
import ru.tB.command.StopCommand;

@DisplayName("Unit-level testing for StopCommnd")
public class StopCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return CommandName.STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StopCommand.STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}

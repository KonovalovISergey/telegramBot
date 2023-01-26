package ru.tB;

import org.junit.jupiter.api.DisplayName;
import ru.tB.command.Command;
import ru.tB.command.CommandName;
import ru.tB.command.HelpCommand;

@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return CommandName.HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HelpCommand.HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}

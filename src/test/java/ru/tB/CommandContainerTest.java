package ru.tB;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.tB.command.Command;
import ru.tB.command.CommandContainer;
import ru.tB.command.CommandName;
import ru.tB.command.UnknownCommand;
import ru.tB.service.SendBotMessageService;

import java.util.Arrays;

public class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService);
    }

    @Test
    public void shouldGetAllTheExistingCommands () {
        // when-then
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                }
        );
    }

    @Test
    public void shouldReturnUnknownCommand() {
        // given - подготавливаем все необходимое к тесту
        String unknownCommand = "/fgskdfhn";

        //when - запускаем тот метод, который планируем тестировать
        Command command = commandContainer.retrieveCommand(unknownCommand);

        //then - проверяем, правильно ли отработал метод
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }

}

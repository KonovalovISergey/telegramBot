package ru.tB.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.tB.service.SendBotMessageService;
import ru.tB.service.TelegramUserService;

import java.util.Arrays;

public class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
        commandContainer = new CommandContainer(sendBotMessageService, telegramUserService);
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

package ru.tB.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.tB.service.SendBotMessageService;

public class NoCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String NO_MESSAGE = "Я поддерживаю команды начинающиеся со слеша(/).\n" +
            "Чтобы посмотреть доступные команды введите /help";

    public NoCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update updates) {
        sendBotMessageService.sendMessage(updates.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}

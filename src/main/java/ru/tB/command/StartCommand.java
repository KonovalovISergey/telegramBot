package ru.tB.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.tB.service.SendBotMessageService;

public class StartCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public static final String START_MESSAGE = "Привет! Я обычный бот, который поможет тебе быть в курсе послежних статей " +
            "тех авторов, которые тебе интересны. Я еще мал и только учусь.";

    // Здесь не добавляем сервис через получение из Application Context.
    // Потому что если это сделать так, то будет циклическая зависимость, которая
    // ломает работу приложения.
    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update updates) {
        sendBotMessageService.sendMessage(updates.getMessage().getChatId().toString(), START_MESSAGE);
    }
}

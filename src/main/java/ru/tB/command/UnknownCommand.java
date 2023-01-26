package ru.tB.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.tB.service.SendBotMessageService;

public class UnknownCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String UNKNOWN_MESSAGE = "Не понимаю вас, напишите /help чтобы узнать что я понимаю.";


    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update updates) {
        sendBotMessageService.sendMessage(updates.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}

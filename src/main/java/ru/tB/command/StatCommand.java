package ru.tB.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.tB.service.SendBotMessageService;
import ru.tB.service.TelegramUserService;

public class StatCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String STAT_MESSAGE = "Telegram bot использует %s человек";

    @Autowired
    public StatCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update updates) {

        int activeUserCount = telegramUserService.retrieveAllActiveUsers().size();
        sendBotMessageService.sendMessage(updates.getMessage().getChatId().toString(), String.format(STAT_MESSAGE, activeUserCount));

    }
}

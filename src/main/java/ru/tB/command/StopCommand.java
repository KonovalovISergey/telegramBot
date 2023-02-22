package ru.tB.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.tB.service.SendBotMessageService;
import ru.tB.service.TelegramUserService;

public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String STOP_MESSAGE = "Деактевировал все ваши подписки (";

    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update updates) {

        sendBotMessageService.sendMessage(updates.getMessage().getChatId().toString(), STOP_MESSAGE);
        telegramUserService.findByChatId(updates.getMessage().getChatId().toString())
                .ifPresent(it -> {
                    it.setActive(false);
                    telegramUserService.save(it);
                });

    }
}

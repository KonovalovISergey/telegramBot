package ru.tB.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.tB.service.SendBotMessageService;

public class HelpCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("<b>Доступные команды:</b> \n\n" +
            "<b>Начать\\закончить работу с ботом</b>\n" +
            "%s - начать работу со мной \n" +
            "%s - приостановить работу со мной \n" +
            "%s - получить помощь в работе со мной \n" +
            "%s - посмотреть статистику \n",
            CommandName.START.getCommandName(), CommandName.STOP.getCommandName(), CommandName.HELP.getCommandName(), CommandName.STAT.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update updates) {
        sendBotMessageService.sendMessage(updates.getMessage().getChatId().toString(), HELP_MESSAGE);

    }
}

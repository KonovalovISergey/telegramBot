package ru.tB.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.tB.command.CommandContainer;
import ru.tB.command.CommandName;
import ru.tB.service.SendBotMessageServiceImpl;
import ru.tB.service.TelegramUserService;

@Component
public class MyBot extends TelegramLongPollingBot {

	public static String COMMAND_PREFIX = "/";

	@Value("${bot.username}")
	private String userName;

	@Value("${bot.token}")
	private String token;

	@Override
	public String getBotUsername() { //здесь нужно добавить username бота, с которым будем соединяться
		return userName;
	}

	@Override
	public String getBotToken() { // собственно, токен бота
		return token;
	}

	private final CommandContainer commandContainer;

	@Autowired
	public MyBot(TelegramUserService telegramUserService) {
		this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this), telegramUserService);
	}

	@Override
	public void onUpdateReceived(Update update) { //это и есть точка входа, куда будут поступать сообщения от пользователей. Отсюда будет идти вся новая логика

		if (update.hasMessage() && update.getMessage().hasText()) {
			String message = update.getMessage().getText().trim();

			if(message.startsWith(COMMAND_PREFIX)){
				String commandIdentifier = message.split(" ")[0].toLowerCase();
				commandContainer.retrieveCommand(commandIdentifier).execute(update);
			} else {
				commandContainer.retrieveCommand(CommandName.NO.getCommandName()).execute(update);
			}
		}

	}
}

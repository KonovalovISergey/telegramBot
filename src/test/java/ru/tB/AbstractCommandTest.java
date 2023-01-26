package ru.tB;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.tB.bot.MyBot;
import ru.tB.command.Command;
import ru.tB.service.SendBotMessageService;
import ru.tB.service.SendBotMessageServiceImpl;

public abstract class AbstractCommandTest {

    protected MyBot myBot = Mockito.mock(MyBot.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(myBot);

    abstract String getCommandName();
    abstract String getCommandMessage();
    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        //given - подготавливаем все необходимое к тесту
        Long chatID = 1234567824356L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatID);
        Mockito.when(message.getText()).thenReturn(getCommandMessage());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        //when
        getCommand().execute(update);

        //then
        Mockito.verify(myBot).execute(sendMessage);
    }

}

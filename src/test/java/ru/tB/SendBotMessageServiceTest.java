package ru.tB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.tB.bot.MyBot;
import ru.tB.service.SendBotMessageService;
import ru.tB.service.SendBotMessageServiceImpl;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private MyBot myBot;

    @BeforeEach
    public void init() {
        myBot = Mockito.mock(MyBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(myBot);
    }
    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given - подготавливаем все необходимое к тесту
        String chatid = "testChatId";
        String message = "testMessage";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatid);
        sendMessage.enableHtml(true);

        //when - запускаем тот метод, который планируем тестировать
        sendBotMessageService.sendMessage(chatid, message);

        //then - проверяем, правильно ли отработал метод
        Mockito.verify(myBot).execute(sendMessage);
    }

}

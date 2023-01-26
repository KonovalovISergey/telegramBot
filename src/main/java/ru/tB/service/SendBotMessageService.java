package ru.tB.service;

public interface SendBotMessageService {
    /**
     * Отправить сообщение в телеграм бот.
     *
     * @param chatId предоставляет идентификатор чата, в который будет отправлено сообщение.
     * @param message предоставляет сообщение для отправки.
     */
    void sendMessage(String chatId, String message);

}

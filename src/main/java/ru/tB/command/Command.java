package ru.tB.command;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Интерфейс Команда для обработки команд бота
 */
public interface Command {

    void execute(Update updates);

}

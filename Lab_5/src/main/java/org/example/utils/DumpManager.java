package org.example.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.models.Ticket;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * Класс для работы с сериализацией и десериализацией коллекции билетов в JSON.
 * Обеспечивает сохранение и загрузку данных из файла.
 */
public class DumpManager {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        // Регистрируем модуль для поддержки LocalDateTime и других классов Java 8 даты/времени
        mapper.registerModule(new JavaTimeModule());
        // Форматирование вывода для красоты
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * Сохраняет коллекцию билетов в JSON-файл.
     *
     * @param tickets коллекция билетов для сохранения
     * @param filePath путь к файлу для сохранения
     * @throws IOException если произошла ошибка ввода-вывода
     * @throws IllegalArgumentException если filePath некорректен
     */
    public static void saveTicket(Collection<Ticket> tickets, String filePath) throws IOException {
        mapper.writeValue(new File(filePath), tickets);
    }

    /**
     * Загружает коллекцию билетов из JSON-файла.
     *
     * @param filePath путь к файлу для загрузки
     * @return коллекция билетов (пустая, если файл пустой)
     * @throws IOException если произошла ошибка ввода-вывода
     * @throws IllegalArgumentException если filePath некорректен
     */
    public static List<Ticket> loadTicket(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.length() > 0)
            return mapper.readValue(file, new TypeReference<Vector<Ticket>>() {
            });
        return new Vector<>();
    }
}

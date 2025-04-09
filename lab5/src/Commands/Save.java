package Commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Scanner;
import utils.*;
import models.*;


public class Save extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public Save(Console console, CollectionManager collectionManager) {
        super("save", "сохранить коллекцию в файл");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) {
                throw new Exception();
            }
            String envPath = System.getenv("COLLECTION_FILE");
            if (envPath == null || envPath.trim().isEmpty()) {
                throw new IllegalStateException("Переменная окружения не установлена");
            }
            File file = new File(envPath);
            if (file.exists()) {
                try (Scanner scanner = new Scanner(file)) {
                    console.println("Текущее содержимое файла:");
                    while (scanner.hasNextLine()) {
                        console.println(scanner.nextLine());
                    }
                }
            }

            Collection<Ticket> collection = collectionManager.getCollection();
            if (collection.isEmpty()) {
                console.println("Коллекция пуста");
                return;
            }

            try (PrintWriter writer = new PrintWriter(file)) {
                writer.println("[");
                boolean first = true;
                for (Ticket ticket: collection) {
                    if (!first) {
                        writer.println(",");
                    }
                    writer.print("  {");
                    writer.print("\"id\": " + ticket.getId() + ", ");
                    writer.print("\"name\": \"" + escapeJson(ticket.getName()) + "\", ");
                    writer.print("\"coordinates\": " + coordinatesToJson(ticket.getCoordinates()) + ", ");
                    writer.print("\"creationDate\": \"" + ticket.getCreationDate() + "\", ");
                    writer.print("\"price\": " + ticket.getPrice() + ", ");
                    writer.print("\"refundable\": " + ticket.getRefundable() + ", ");
                    writer.print("\"type\": \"" + ticket.getType() + "\", ");
                    writer.print("\"venue\": " + (ticket.getVenue() != null ? venueToJson(ticket.getVenue()) : "null"));
                    writer.print("}");
                    first = false;
                }
                writer.println("\n]");
                console.println("Коллекция успешно сохранена в: " + envPath);
            }
        } catch (FileNotFoundException e) {
            console.println("Ошибка: файл не найден или нет прав доступа");
        } catch (Exception e) {
            console.println("Ошибка сохранения: " + e.getMessage());
        }
    }
    private String escapeJson(String input) {
        return input.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    private String coordinatesToJson(Coordinates coordinates) {
        return String.format("{\"x\": %f, \"y\": %f}",
                coordinates.getX(), coordinates.getY());
    }

    private String venueToJson(Venue venue) {
        return String.format("{" +
                        "\"id\": %d, " +
                        "\"name\": \"%s\", " +
                        "\"capacity\": %d, " +
                        "\"type\": \"%s\"" +
                        "}",
                venue.getId(),
                escapeJson(venue.getName()),
                venue.getCapacity(),
                venue.getType());
    }
}

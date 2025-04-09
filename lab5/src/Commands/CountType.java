package Commands;

import models.TicketType;
import utils.*;



public class CountType extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public CountType(Console console, CollectionManager collectionManager) {
        super("count_greater_than_type", "вывести количество элементов, значение поля type которых больше заданного");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (arguments.isEmpty()) {
                throw new IllegalArgumentException("не указан тип данных для сравнения");
            }
            if (collectionManager.getCollection().isEmpty()) {
                console.println("Коллекция пуста");
                return;
            }
            TicketType inputType;
            try {
                inputType = TicketType.valueOf(arguments.trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                console.println("ты дебил! такого типа билета нет");
                return;
            }
            long count = collectionManager.getCollection().stream()
                    .filter(ticket -> ticket.getType() != null)
                    .filter(ticket -> ticket.getType().ordinal() > inputType.ordinal())
                    .count();
            console.println("количество элементов в коллекции " + inputType + ": " + count);

        } catch (Exception e) {
            console.println("Ты дебил! тут ошибка");
        }
    }
}

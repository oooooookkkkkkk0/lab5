package Commands;

import utils.*;
import models.*;

import java.util.Comparator;

public class Sort extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public Sort(Console console, CollectionManager collectionManager) {
        super("sort", "отсортировать коллекцию в естественном порядке");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) {
                throw new IllegalArgumentException("команда не принимает аргументы");
            }
            if (collectionManager.getCollection().isEmpty()) {
                console.println("Коллекция пуста");
            }
            collectionManager.getCollection().sort(Comparator.comparing(Ticket::getId));
        } catch (IllegalStateException e) {
            console.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            console.println(e.getMessage());
        }
    }
}

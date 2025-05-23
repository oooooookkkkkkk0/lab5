package Commands;
import utils.*;
import models.*;

import java.util.NoSuchElementException;

import static java.lang.Integer.parseInt;

public class Remove extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public Remove(Console console, CollectionManager collectionManager) {
        super("remove_by_id", "удалить элемент из коллекции по его id");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (arguments.isEmpty()) {
                throw new IllegalArgumentException("не указан id");
            }
            int id = parseInt(arguments);
            if (id <= 0) {
                throw new IllegalArgumentException("у билетов не может быть отрицательного id(((");

            }

            Ticket ticket = collectionManager.byId(id);
            if (ticket == null) {
                throw new NoSuchElementException("нет билета с id " + id);
            }

            collectionManager.remove(id);
            if (collectionManager.byId(id) != null) {
                throw new RuntimeException("ошибка при удалении");
            }
            console.println("Ticket успешно удален");
        } catch (NumberFormatException e) {
            console.println("id должен быть целым числом");
        } catch (NoSuchElementException e) {
            console.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            console.println(e.getMessage());
        } catch (Exception e) {
            console.println(e.getMessage());
        }
    }
}
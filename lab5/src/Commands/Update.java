package Commands;

import utils.Ask;
import utils.CollectionManager;
import utils.Console;
import models.*;

import java.util.NoSuchElementException;

import static java.lang.Integer.parseInt;

public class Update extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public Update(Console console, CollectionManager collectionManager) {
        super("update", "обновить значение элемента коллекции, id которого равен заданному");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (arguments.isEmpty()) {
                throw new IllegalArgumentException("не указан id и данные элемента");
            }
            String[] args = arguments.split(" ", 1);
            if (args.length < 1) {
                throw new IllegalArgumentException("ты не все ввел");
            }

            int id = parseInt(args[0]);
            Ticket oldTicket = collectionManager.byId(id);
            if (oldTicket == null) {
                throw new NoSuchElementException("элемента с таким id нет");
            }
            console.println("введи новые данные");
            Ticket newTicket = Ask.AskTicket(console);

            newTicket.getCreationDate();
            collectionManager.remove(id);
            collectionManager.add(newTicket);

            console.println("элемент с id " + id + " обнoвлен");

        } catch (NumberFormatException e) {
            console.println("id должен быть целым");
        } catch (NoSuchElementException e) {
            console.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            console.println(e.getMessage());
        }
    }
}

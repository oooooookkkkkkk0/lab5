package Commands;
import utils.*;
import models.*;

public class Show extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public Show (Console console, CollectionManager collectionManager) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) {
                throw new Exception();
            }

            if (collectionManager.getCollection().isEmpty()) {
                throw new Exception();
            }
            for (Ticket ticket: collectionManager.getCollection()) {
                console.println(ticket.toString());
            }

        } catch (Exception e) {
            console.println("Ты дебил! Коллекция пуста");
        }
    }
}

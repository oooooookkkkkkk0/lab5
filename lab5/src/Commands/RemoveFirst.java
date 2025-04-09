package Commands;
import utils.*;

public class RemoveFirst extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public RemoveFirst(Console console, CollectionManager collectionManager) {
        super("remove_first", "удалить первый элемент из коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) {
                throw new IllegalArgumentException("коллекция не принимает аргументы");
            }

            if (collectionManager.getCollection() == null) {
                throw new IllegalStateException("коллекция не инициализирована");
            }

            if (collectionManager.getCollection().isEmpty()) {
                throw new IllegalStateException("коллекция пуста");
            }

            collectionManager.getCollection().remove(0);
            console.println("Ticket успешно удален");
        } catch (IllegalArgumentException e) {
            console.println(e.getMessage());
        } catch (IllegalStateException e) {
            console.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            console.println("не удалось удалить первый элемент");
        }
    }
}
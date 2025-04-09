package Commands;
import utils.*;

public class Clear extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public Clear (Console console, CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) {
                throw new IllegalArgumentException("не принимает аргументы");
            }

            if (collectionManager.getCollection() == null) {
                throw new IllegalArgumentException("коллекция не инициализирована");
            }
            if (collectionManager.getCollection().isEmpty()) {
                throw new IllegalStateException("коллекция пуста(");
            }

            collectionManager.clear();
            console.println("коллекция очищена");

        } catch (IllegalArgumentException e) {
            console.println(e.getMessage());
        } catch (IllegalStateException e) {
            console.println(e.getMessage());
        } catch (NullPointerException e) {
            console.println("коллекции не существует");
        }
    }
}
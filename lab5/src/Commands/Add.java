package Commands;


import utils.*;

public class Add extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public Add(Console console, CollectionManager collectionManager) {
        super("add", "добавляет новый элемент в коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) {
                throw new IllegalArgumentException("не указаны данные элемента");
            }
            collectionManager.add(Ask.AskTicket(console));
            console.println("Ticket успешно добавлен");
        } catch(IllegalArgumentException e){
            console.println(e.getMessage());
        } catch (NullPointerException e) {
            console.println("неправильные данные элемента");
        }
    }
}
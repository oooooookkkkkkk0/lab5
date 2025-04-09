package Commands;

import utils.*;
import models.*;

import java.util.Vector;

public class InsertAt extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public InsertAt(Console console, CollectionManager collectionManager) {
        super("insert_at", "добавить новый элемент в заданную позицию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
//            if (!arguments.isEmpty()) {
//                throw new Exception();
//            }
//            String[] args = arguments.split(" ", 1);

            int index = parseIndex(arguments);
            console.println(index);
            if (index == -1) {
                console.println("такого индекса нет");
                return;
            }
            Ticket newTicket = parseTicketFromString();;

            var collection = collectionManager.getCollection();
            Vector<Ticket> newColl = new Vector<>();
//            collectionManager.clear();
            for (int i = 0; i < collection.size(); i ++) {
                if (i == index) {
                    newColl.add(newTicket);
                }
                newColl.add(collection.get(i));
            }
            collectionManager.setCollection(newColl);

//            collectionManager.getCollection().add(index, newTicket);
            console.println("элемент успешно добавлен на позицию" + index);
        } catch (Exception e) {
            console.println("ты дебил! тут ошибка хуй");
        }
    }

    private int parseIndex(String indexStr) {
        try {
            int index = Integer.parseInt(indexStr);
            if (index < 0 || index > collectionManager.getCollection().size()) {
                throw new IllegalArgumentException("неверный индекс");
            }
            return index;
            } catch (Exception e) {
                console.println("тут ошибка");
        }
        return -1;
    }
    private Ticket parseTicketFromString() {
        return Ask.AskTicket(console);
    }
}


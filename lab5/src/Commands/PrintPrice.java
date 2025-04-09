package Commands;

import utils.*;
import models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintPrice extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public PrintPrice (Console console, CollectionManager collectionManager) {
        super("print_field_descending_price", "вывести значения поля price всех элементов в порядке убывания");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()){
                throw new Exception();
            }

            if (collectionManager.getCollection().isEmpty()) {
                console.println("коллекция пуста");
                return;
            }
            List<Integer> prices = new ArrayList<>();
            for (Ticket ticket: collectionManager.getCollection()) {
                prices.add(ticket.getPrice());
            }

            prices.sort(Collections.reverseOrder());

            console.println("цены в порядке убывания");
            for (int price : prices) {
                console.println(price);
            }
        } catch (Exception e) {
            console.println("ты дебил! тут ошибка");
        }
    }
}

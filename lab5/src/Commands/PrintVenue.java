package Commands;

import utils.*;
import models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class PrintVenue extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public PrintVenue(Console console, CollectionManager collectionManager) {
        super("print_field_ascending_venue", "вывести значения поля venue всех элементов в порядке возрастания");
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
                console.println("коллекция пуста");
                return;
            }
            List<Venue> venues = new ArrayList<>();
            for (Ticket tickets : collectionManager.getCollection()) {
                Venue venue = tickets.getVenue();
                if (venue != null) {
                    venues.add(venue);
                }
            }

            Collections.sort(venues, new Comparator<Venue>() {
                @Override
                public int compare(Venue v1, Venue v2) {
                    return Integer.compare(v1.getId(), v2.getId());
                }
            });

            console.println("список venue" + venues.size());
            for (Venue venue : venues) {
                printVenue(venue);
            }
        } catch (Exception e) {
            console.println("ты дебил! тут ошибка");
        }
    }

    private void printVenue(Venue venue) {
        console.println("id: " + venue.getId());
        console.println("name: " + (venue.getName() != null ? venue.getName() : "не указан"));
        console.println("capacity: " + venue.getCapacity());
        console.println("type: " + (venue.getType() != null ? venue.getType() : "не указан"));
    }
}

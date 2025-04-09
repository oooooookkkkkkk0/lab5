package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import models.*;

public class CollectionManager {
    private Vector<Ticket> collection = new Vector<>();
    private Map<Integer, Ticket> tickets = new HashMap<>();

    public void add(Ticket ticket) {
        collection.add(ticket);
        tickets.put(ticket.getId(), ticket);
    }

    public Ticket byId (Integer id) {
        return tickets.get(id);
    }

    public void remove(Integer id) {
        collection.remove(byId(id));
        tickets.remove(id);
    }

    public Vector<Ticket> getCollection() {
        return collection;
    }

    public void clear() {
        collection.clear();
    }
    public void setCollection(Vector<Ticket> newCol){
        collection.clear();
        collection = newCol;
    }
}

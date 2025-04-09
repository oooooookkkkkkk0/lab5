package models;


public class Ticket {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int price; //Значение поля должно быть больше 0
    private boolean refundable;
    private TicketType type; //Поле не может быть null
    private Venue venue;//Поле может быть null

    public Ticket (Integer id, String name, Coordinates coordinates, java.time.LocalDateTime creationDate, int price, boolean refundable, TicketType type, Venue venue) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.price = price;
        this.refundable = refundable;
        this.type = type;
        this.venue = venue;
    }


    public String toString() {
        return "Ticket{\"id\": " + id + ", " +
                "\"name\": \"" + name + "\", " +
                "\"coordinates\": \"" + coordinates + "\", " +
                "\"creationDate\": \"" + creationDate + "\", " +
                "\"price\": \"" + price + "\", " +
                "\"refundable\": \"" + refundable + "\", " +
                "\"type\": \"" + type + "\", " +
                "\"venue\": \"" + "\"venueId\": \"" + venue.getId() + "\", " +
                "\"venueName\"" + venue.getName() + "\", " +
                "\"venueType\"" + venue.getType() + "\"}";
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public java.time.LocalDateTime getCreationDate() {
        return creationDate;
    }

    public int getPrice() {
        return price;
    }

    public boolean getRefundable() {
        return refundable;
    }

    public TicketType getType() {
        return type;
    }

    public Venue getVenue() {
        return venue;
    }

    public void updateById(Ticket updateTicket) {
        this.name = updateTicket.getName();
        this.coordinates = updateTicket.getCoordinates();
        this.price = updateTicket.getPrice();
        this.refundable = updateTicket.getRefundable();
        this.type = updateTicket.getType();
        this.venue = updateTicket.getVenue();
    }
}
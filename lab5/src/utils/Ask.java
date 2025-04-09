package utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

import models.*;

public class Ask {
    public static Ticket AskTicket(Console console) {
        long id = IdGenerator.getNextId();

        String name = AskName(console);

        Coordinates coordinates = Askcoordinates(console);

        Venue venue = AskVenue(console);

        TicketType ticketType = AskTicketType(console);

        int price = AskPrice(console);

        console.println("Введите refundable");
        boolean refundable = parseBoolean(console.readln());

        LocalDateTime creationDate = AskLocalDate(console);

        return new Ticket(parseInt(String.valueOf(id)), name, coordinates, creationDate, price, refundable, ticketType, venue);
    }

    private static Coordinates Askcoordinates(Console console) {
        while (true) {
            console.println("Введите coordinates");
            console.println("Введите x");
            console.println("Введите y");
            try {
                Float x = parseFloat(console.readln());
                double y = parseDouble(console.readln());
                if (x.equals(null)) {
                    throw new Exception();
                }
                return new Coordinates(x, y);
            } catch (NumberFormatException e) {
                console.println("Ты дебил, введи число");
            } catch (Exception e) {
                console.println("Ты дебил, введи число");
            }
        }
    }

    private static String AskVenueName(Console console) {
        while (true) {
            console.println("введите имя");
            try {
                String name = console.readln();
                if (name.isEmpty()) {
                    throw new Exception();
                }
                if (!name.matches("^[a-zA-Zа-яА-Я\\s]+$")){
                    throw new IllegalArgumentException("у name тип string");
                }
                return name;
            } catch (Exception e) {
                console.println("тут ошибка(");
            }
        }
    }

    private static String AskVenueCapacity(Console console) {
        while (true) {
            console.println("введите capacity");
            try {
                String capacity = console.readln();
                if (capacity.isEmpty()) {
                    throw new Exception();
                }

                long capacityNew = Long.parseLong(capacity);
                if (capacityNew < 0) {
                    throw new IllegalArgumentException("тут должно быть положительное число");
                }
                return capacity;
            } catch (Exception e) {
                console.println("тут ошибка(");
            }
        }
    }


    private static String AskVenueType(Console console) {
        while (true) {
            try {
                console.println("введите тип: BAR, LOFT, THEATRE, MALL, STADIUM");
                String input = console.readln().trim().toUpperCase();

                // Проверка на пустой ввод
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("тут не должно быть пусто(");
                }

                // Ручная проверка через enum
                for (VenueType type : VenueType.values()) {
                    if (type.name().equals(input)) {
                        return input; // Возвращаем валидную строку
                    }
                }

                // Если не нашли совпадение
                throw new IllegalArgumentException("такого типа быть не может(");

            } catch (IllegalArgumentException e) {
                // Формируем список допустимых значений из enum
                String validTypes = Arrays.stream(VenueType.values())
                        .map(Enum::name)
                        .collect(Collectors.joining(", "));
                console.println("Ошибка! Допустимые значения: " + validTypes);
            }
        }
    }

    private static Venue AskVenue(Console console) {
        while (true) {
            console.println("Введите venue");
            long id = IdGenerator.getNextId();
            String name = AskVenueName(console);
            String capacity = AskVenueCapacity(console);
            String type = AskVenueType(console);
            return new Venue(parseInt(String.valueOf(id)), name, parseLong(capacity), VenueType.valueOf(type));
        }


//        while (true) {
//            console.println("Введите id");
//            String id = console.readln();
//            console.println("Введите name");
//            String name = console.readln();
//            console.println("Введите capacity");
//            String capacity = console.readln();
//            console.println("Введите type: BAR, LOFT, THEATRE, MALL, STADIUM");
//            String type = console.readln();
//            try {
//                return new Venue(parseInt(id), name, parseLong(capacity), VenueType.valueOf(type));
//            } catch (Exception e) {
//                console.println("Введите нужный тип данных");
//            }
//        }
    }


    private static String AskName(Console console) {
        while (true) {
            console.println("Введите name");
            try {
                String name = console.readln();
                if (name.isEmpty()) {
                    throw new Exception();
                }
                return name;
            } catch (Exception e) {
                console.println("Ты дебил, введи строку");
            }
        }
    }

    private static TicketType AskTicketType(Console console) {
        while (true) {
            console.println("Введите ticketType: VIP, USUAL, BUDGETARY, CHEAP");
            try {
                TicketType ticketType = TicketType.valueOf(console.readln());
                if (ticketType.equals(null)) {
                    throw new Exception();
                }
                return ticketType;
            } catch (Exception e) {
                console.println("Ты дебил, введи нужный тип");
            }
        }
    }

    private static int AskPrice(Console console) {
        while (true) {
            console.println("Введите price");
            try {
                int price = parseInt(console.readln());
                if (price <= 0) {
                    throw new Exception();
                }
                return price;
            } catch (Exception e) {
                console.println("Ты дебил, введи число");
            }
        }
    }

    private static LocalDateTime AskLocalDate (Console console) {
        while (true) {
            LocalDateTime creationDate = LocalDateTime.now();
            try {
                if (creationDate.equals(null)) {
                    throw new Exception();
                }
                return creationDate;
            } catch (Exception e) {
                console.println("Дебил, тут должна быть дата");
            }

        }
    }


}

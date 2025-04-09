import Commands.*;
import utils.CollectionManager;
import utils.CommandManager;
import utils.Console;


public class Main {
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        CommandManager commandManager = new CommandManager();
        Console console = new Console();
        commandManager.add(new Add(console, collectionManager));
        commandManager.add(new Show(console, collectionManager));
        commandManager.add(new Help(console, commandManager));
        commandManager.add(new Remove(console, collectionManager));
        commandManager.add(new Clear(console, collectionManager));
        commandManager.add(new Save(console, collectionManager));
        commandManager.add(new RemoveFirst(console, collectionManager));
        commandManager.add(new Sort(console, collectionManager));
        commandManager.add(new CountType(console, collectionManager));
        commandManager.add(new PrintVenue(console, collectionManager));
        commandManager.add(new PrintPrice(console, collectionManager));
        commandManager.add(new Exit(console, commandManager));
        commandManager.add(new InsertAt(console, collectionManager));
        commandManager.add(new Update(console, collectionManager));

        String[] userCommand = {"", ""};
        console.println("Введите команду --> ");
        while (true) {
            try {
                userCommand = (console.readln().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                Command command = commandManager.getCommands().get(userCommand[0]);
                command.apply(userCommand[1]);
            } catch (Exception e) {
                console.println("Ты дебил, такой команды нет");
            }
            }
        }
}
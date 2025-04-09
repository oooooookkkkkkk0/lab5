package Commands;
import utils.*;

public class Exit extends Command {
    private Console console;
    private CommandManager commandManager;

    public Exit (Console console, CommandManager commandManager) {
        super("exit", "завершить программу (без сохранения в файл)");
        this.console = console;
        this.commandManager = commandManager;
    }

    @Override
    public void apply(String arguments) {
        try {
            if (!arguments.isEmpty()) {
                throw new Exception();
            }
            console.println("ты точно хочешь закончить?");
            String confirmation = console.readln().trim().toLowerCase();

            if (confirmation.equals("да") || confirmation.equals("yes")) {
                console.println("завершение программы");
                commandManager.stopExecution();
                System.exit(0);
            } else {
                console.println("продолжаем");
            }
        } catch (Exception e) {
            console.println("ты дебил! тут ошибка");
            System.exit(1);
        }
    }
}

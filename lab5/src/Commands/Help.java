package Commands;
import utils.*;

import utils.CommandManager;

import java.util.Map;

public class Help extends Command {
    private Console console;
    private CommandManager commandManager;

    public Help (Console console, CommandManager commandManager) {
        super("help", "выводит справку по достпуным командам");
        this.console = console;
        this.commandManager = commandManager;
    }

    @Override
    public void apply(String arguments) {
        Map<String, Command> map = commandManager.getCommands();
        for (Command command: map.values()) {
            console.println(command.getName() + "-" + command.getDescription());
        }
    }
}

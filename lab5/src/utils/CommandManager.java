package utils;

import Commands.Command;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommandManager {
   private Map<String, Command> commands = new LinkedHashMap<>();

   public void add(Command command) {
       commands.put(command.getName(), command);
   }

   public Map<String, Command> getCommands() {
       return commands;
   }

   private boolean isRunning = true;
   public void stopExecution() {
       this.isRunning = false;
   }
   public boolean isRunning() {
       return this.isRunning;
   }
}

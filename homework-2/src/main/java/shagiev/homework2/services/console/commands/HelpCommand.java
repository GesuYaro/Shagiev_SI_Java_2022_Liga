package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HelpCommand implements Command {

    private final Writer writer;
    private final Map<String, Command> commandMap;
    private final String description = "Show commands";

    public HelpCommand(Writer writer, List<Command> commandList) {
        this.writer = writer;
        this.commandMap = new HashMap<>();
        for (Command command : commandList) {
            commandMap.put(command.getName(), command);
        }
    }

    @Override
    public boolean execute(String[] args) {
        try {
            for (String commandName : commandMap.keySet()) {
                writer.write(commandName);
                writer.write(" | ");
                if (commandMap.get(commandName).getDescription() != null) {
                    writer.write(commandMap.get(commandName).getDescription());
                } else {
                    writer.write("no description");
                }
                writer.write("\r\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.err.println("Problem with printing");
        }
        return false;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return description;
    }
}
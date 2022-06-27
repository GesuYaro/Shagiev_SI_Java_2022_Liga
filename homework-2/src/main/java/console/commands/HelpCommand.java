package console.commands;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

@RequiredArgsConstructor
public class HelpCommand implements Command {

    private final Writer writer;
    private final Map<String, Command> commandMap;
    private final String description = "Show commands";

    @Override
    public boolean invoke(String[] args) {
        try {
            for (String commandName : commandMap.keySet()) {
                writer.write(commandName);
                writer.write(" | ");
                if (commandMap.get(commandName).getDescription() != null) {
                    writer.write(commandMap.get(commandName).getDescription());
                } else {
                    writer.write("no description");
                }
                writer.write("\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.err.println("Problem with printing");
        }
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

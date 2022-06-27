package console;

import console.commands.Command;
import console.commands.NotEnoughArgumentsException;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Scanner;

@RequiredArgsConstructor
public class Console {

    private final Map<String, Command> commandMap;
    private final Scanner scanner;
    private final Writer writer;

    public void run() throws IOException {
        boolean isExit = false;
        while (!isExit) {
            String[] commandAndArgs = scanner.nextLine().split(" ");
            String command = commandAndArgs[0];
            if (!command.isEmpty()) {
                String[] args = null;
                if (commandAndArgs.length > 1) {
                    args = new String[commandAndArgs.length - 1];
                    System.arraycopy(commandAndArgs, 1, args, 0, commandAndArgs.length - 1);
                }
                if (commandMap.containsKey(command)) {
                    try {
                        isExit = commandMap.get(commandAndArgs[0]).invoke(args);
                    } catch (NotEnoughArgumentsException | NumberFormatException e) {
                        writer.write("Argument error. ");
                        writer.write(e.getMessage());
                        writer.write("\n");
                        writer.flush();
                    }
                } else {
                    writer.write("Command ");
                    writer.write(command);
                    writer.write(" not found\n");
                    writer.flush();
                }
            }
        }
    }

}

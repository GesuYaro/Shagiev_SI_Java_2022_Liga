package shagiev.homework2.services.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shagiev.homework2.services.console.commands.Command;
import shagiev.homework2.services.console.commands.CommandName;
import shagiev.homework2.services.console.commands.NotEnoughArgumentsException;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CommandHandlerImpl implements CommandHandler {

    private final Map<CommandName, Command> commandMap;
    private final ByteArrayOutputStream byteArrayOutputStream;

    public CommandHandlerImpl(List<Command> commandList, ByteArrayOutputStream byteArrayOutputStream) {
        this.byteArrayOutputStream = byteArrayOutputStream;
        commandMap = new HashMap<>();
        for (Command command : commandList) {
            commandMap.put(command.getName(), command);
        }
    }

    @Override
    public String handleCommand(String command) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream))) {
            String[] commandAndArgs = command.split(" ");
            String commandPart = commandAndArgs[0];
            if (!commandPart.isEmpty()) {
                String[] args = null;
                if (commandAndArgs.length > 1) {
                    args = new String[commandAndArgs.length - 1];
                    System.arraycopy(commandAndArgs, 1, args, 0, commandAndArgs.length - 1);
                }
                CommandName key = null;
                try {
                    key = CommandName.valueOf(commandPart.toUpperCase());
                } catch (IllegalArgumentException e) {
                    writer.write("Command ");
                    writer.write(commandPart);
                    writer.write(" not found\n");
                    writer.flush();
                }
                if (key != null) {
                    if (commandMap.containsKey(key)) {
                        try {
                            commandMap.get(CommandName.valueOf(commandPart.toUpperCase())).execute(args);
                        } catch (NotEnoughArgumentsException | NumberFormatException e) {
                            writer.write("Argument error. ");
                            writer.write(e.getMessage());
                            writer.write("\n");
                            writer.flush();
                        }
                    } else {
                        writer.write("Command ");
                        writer.write(commandPart);
                        writer.write(" not implemented\n");
                        writer.flush();
                    }
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        String result = byteArrayOutputStream.toString();
        byteArrayOutputStream.reset();
        return result;
    }

}

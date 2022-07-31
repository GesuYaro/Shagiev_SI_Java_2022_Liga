package shagiev.homework2.services.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shagiev.homework2.dto.command.CommandResponseDTO;
import shagiev.homework2.dto.user.UserInfoDTO;
import shagiev.homework2.services.console.commands.Command;
import shagiev.homework2.services.console.commands.CommandName;
import shagiev.homework2.services.console.commands.NotEnoughArgumentsException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CommandHandlerImpl implements CommandHandler {

    private final Map<CommandName, Command> commandMap;

    public CommandHandlerImpl(List<Command> commandList) {
        commandMap = new HashMap<>();
        for (Command command : commandList) {
            commandMap.put(command.getName(), command);
        }
    }

    @Override
    public String handleCommand(String command) {
        StringBuilder responseStringBuilder = new StringBuilder();
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
                responseStringBuilder.append("Command ");
                responseStringBuilder.append(commandPart);
                responseStringBuilder.append(" not found\n");
            }
            if (key != null) {
                if (commandMap.containsKey(key)) {
                    try {
                        CommandResponseDTO responseDTO = commandMap.get(CommandName.valueOf(commandPart.toUpperCase())).execute(args);
                        addResponseToStringBuilder(responseDTO, responseStringBuilder);
                    } catch (NotEnoughArgumentsException | NumberFormatException e) {
                        responseStringBuilder.append("Argument error. ");
                        responseStringBuilder.append(e.getMessage());
                        responseStringBuilder.append("\n");
                    }
                } else {
                    responseStringBuilder.append("Command ");
                    responseStringBuilder.append(commandPart);
                    responseStringBuilder.append(" not implemented\n");
                }
            }
        }
        return responseStringBuilder.toString();
    }

    private void addResponseToStringBuilder(CommandResponseDTO commandResponseDTO, StringBuilder stringBuilder) {
        if (commandResponseDTO.getMessage() != null) {
            stringBuilder.append(commandResponseDTO.getMessage());
            stringBuilder.append("\n");
        }
        if (commandResponseDTO.getUsers() != null) {
            commandResponseDTO.getUsers().forEach(user -> {
                stringBuilder.append(user);
                stringBuilder.append("\n");
            });
        }
        if (commandResponseDTO.getTasks() != null) {
            commandResponseDTO.getTasks().forEach(task -> {
                stringBuilder.append(task);
                stringBuilder.append("\n");
            });
        }
    }

}

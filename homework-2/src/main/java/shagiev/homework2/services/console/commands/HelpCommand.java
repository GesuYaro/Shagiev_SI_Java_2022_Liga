package shagiev.homework2.services.console.commands;

import org.springframework.stereotype.Component;
import shagiev.homework2.dto.command.CommandResponseDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HelpCommand implements Command {

    private final Map<CommandName, Command> commandMap;

    public HelpCommand(List<Command> commandList) {
        this.commandMap = new HashMap<>();
        for (Command command : commandList) {
            commandMap.put(command.getName(), command);
        }
    }

    @Override
    public CommandResponseDto execute(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (CommandName commandName : commandMap.keySet()) {
            stringBuilder.append(commandName.name());
            stringBuilder.append(" | ");
            if (commandMap.get(commandName).getDescription() != null) {
                stringBuilder.append(commandMap.get(commandName).getDescription());
            } else {
                stringBuilder.append("no description");
            }
            stringBuilder.append("\n");
        }
        return new CommandResponseDto(stringBuilder.toString());
    }

    @Override
    public CommandName getName() {
        return CommandName.HELP;
    }

    @Override
    public String getDescription() {
        return "Show commands";
    }
}

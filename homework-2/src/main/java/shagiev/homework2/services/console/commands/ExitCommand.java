package shagiev.homework2.services.console.commands;

import org.springframework.stereotype.Component;
import shagiev.homework2.dto.command.CommandResponseDTO;

@Component
public class ExitCommand implements Command {

    @Override
    public CommandResponseDTO execute(String[] args) {
        return new CommandResponseDTO();
    }

    @Override
    public CommandName getName() {
        return CommandName.EXIT_COMMAND;
    }

    @Override
    public String getDescription() {
        return "Exit program (without saving)";
    }
}

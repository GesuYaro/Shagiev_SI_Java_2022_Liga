package shagiev.homework2.services.console.commands;

import org.springframework.stereotype.Component;
import shagiev.homework2.dto.command.CommandResponseDto;

@Component
public class ExitCommand implements Command {

    @Override
    public CommandResponseDto execute(String[] args) {
        return new CommandResponseDto();
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

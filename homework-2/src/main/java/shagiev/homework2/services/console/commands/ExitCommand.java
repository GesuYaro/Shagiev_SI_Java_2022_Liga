package shagiev.homework2.services.console.commands;

import org.springframework.stereotype.Component;

@Component
public class ExitCommand implements Command {

    @Override
    public boolean execute(String[] args) {
        return true;
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

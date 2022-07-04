package shagiev.homework2.services.console.commands;

import org.springframework.stereotype.Component;

@Component
public class ExitCommand implements Command {

    private final String description = "Exit program (without saving)";

    @Override
    public boolean execute(String[] args) {
        return true;
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return description;
    }
}

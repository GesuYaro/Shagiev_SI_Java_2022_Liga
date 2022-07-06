package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.services.console.managers.TaskManager;
import shagiev.homework2.services.console.managers.UserManager;

@RequiredArgsConstructor
@Component
public class ClearCommand implements Command {

    private final TaskManager taskManager;
    private final UserManager userManager;

    @Override
    public boolean execute(String[] args) {
        if (args == null || args.length < 1) {
            userManager.clear();
            taskManager.clearAll();
            return false;
        }
        int id = Integer.parseInt(args[0]);
        taskManager.clear(id);
        return false;
    }

    @Override
    public CommandName getName() {
        return CommandName.CLEAR;
    }

    @Override
    public String getDescription() {
        return "{id} clear tasks for user, or all data if id is not provided";
    }

}

package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.services.console.managers.TaskFactory;
import shagiev.homework2.services.console.managers.TaskManager;

@RequiredArgsConstructor
@Component
public class ChangeStatusCommand implements Command {

    private final String description = "{id} change command status";
    private final TaskManager taskManager;
    private final TaskFactory taskFactory;

    @Override
    public boolean execute(String[] args) {
        if (args == null || args.length < 2) {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
            taskManager.updateStatus(id, taskFactory.getTaskStatus(args[1]));
        return false;
    }

    @Override
    public String getName() {
        return "change_status";
    }

    @Override
    public String getDescription() {
        return description;
    }

}

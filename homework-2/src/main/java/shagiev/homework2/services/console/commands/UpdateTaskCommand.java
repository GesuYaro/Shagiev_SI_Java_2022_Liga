package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.services.console.managers.TaskFactory;
import shagiev.homework2.services.console.managers.TaskManager;


@RequiredArgsConstructor
@Component
public class UpdateTaskCommand implements Command {

    private final String description = "{id} update task";
    private final TaskManager taskManager;
    private final TaskFactory taskFactory;

    @Override
    public boolean execute(String[] args) {
        if (args == null || args.length < 7) {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        taskManager.updateTask(id, taskFactory.getTask(args[1], args[2], args[3], args[4], args[5], args[6]));
        return false;
    }

    @Override
    public String getName() {
        return "update_task";
    }

    @Override
    public String getDescription() {
        return description;
    }

}

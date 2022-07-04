package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.services.console.managers.TaskFactory;
import shagiev.homework2.services.console.managers.TaskManager;


@RequiredArgsConstructor
@Component
public class AddTaskCommand implements Command {

    private final String description = "add new task";
    private final TaskFactory taskFactory;
    private final TaskManager taskManager;

    @Override
    public boolean execute(String[] args) {
        if (args != null && args.length >= 5) {
            taskManager.addTask(taskFactory.getTask("0", args[0], args[1], args[2], args[3], args[4]));
        } else {
            throw new NotEnoughArgumentsException();
        }
        return false;
    }

    @Override
    public String getName() {
        return "add_task";
    }

    @Override
    public String getDescription() {
        return description;
    }

}

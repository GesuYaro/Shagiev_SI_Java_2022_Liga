package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.services.console.managers.TaskManager;

@RequiredArgsConstructor
@Component
public class DeleteTaskCommand implements Command{

    private final TaskManager taskManager;

    @Override
    public boolean execute(String[] args) {
        if (args == null || args.length < 1)  {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        taskManager.delete(id);
        return false;
    }

    @Override
    public CommandName getName() {
        return CommandName.DELETE_TASK;
    }

    @Override
    public String getDescription() {
        return "{id} delete task";
    }

}

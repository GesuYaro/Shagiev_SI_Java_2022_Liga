package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.dto.command.CommandResponseDto;
import shagiev.homework2.services.console.managers.TaskFactory;
import shagiev.homework2.services.console.managers.TaskManager;


@RequiredArgsConstructor
@Component
public class AddTaskCommand implements Command {

    private final TaskFactory taskFactory;
    private final TaskManager taskManager;

    @Override
    public CommandResponseDto execute(String[] args) {
        if (args != null && args.length >= 5) {
            String header = args[0];
            String description = args[1];
            String date = args[2];
            String status = args[3];
            String userId = args[4];
            taskManager.addTask(taskFactory.getTask("0", header, description, date, status, userId));
        } else {
            throw new NotEnoughArgumentsException();
        }
        return new CommandResponseDto("ok");
    }

    @Override
    public CommandName getName() {
        return CommandName.ADD_TASK;
    }

    @Override
    public String getDescription() {
        return "add new task";
    }

}

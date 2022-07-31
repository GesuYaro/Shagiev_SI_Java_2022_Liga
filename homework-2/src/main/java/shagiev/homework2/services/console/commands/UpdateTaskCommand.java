package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.dto.command.CommandResponseDTO;
import shagiev.homework2.services.console.managers.TaskFactory;
import shagiev.homework2.services.console.managers.TaskManager;


@RequiredArgsConstructor
@Component
public class UpdateTaskCommand implements Command {

    private final TaskManager taskManager;
    private final TaskFactory taskFactory;

    @Override
    public CommandResponseDTO execute(String[] args) {
        if (args == null || args.length < 6) {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        String idStr = args[0];
        String header = args[1];
        String description = args[2];
        String date = args[3];
        String status = args[4];
        String userId = args[5];
        taskManager.updateTask(id, taskFactory.getTask(idStr, header, description, date, status, userId));
        return new CommandResponseDTO("ok");
    }

    @Override
    public CommandName getName() {
        return CommandName.UPDATE_TASK;
    }

    @Override
    public String getDescription() {
        return "{id} update task";
    }

}

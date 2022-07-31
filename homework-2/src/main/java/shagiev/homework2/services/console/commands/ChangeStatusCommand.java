package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.dto.command.CommandResponseDTO;
import shagiev.homework2.services.console.managers.TaskFactory;
import shagiev.homework2.services.console.managers.TaskManager;

@RequiredArgsConstructor
@Component
public class ChangeStatusCommand implements Command {

    private final TaskManager taskManager;
    private final TaskFactory taskFactory;

    @Override
    public CommandResponseDTO execute(String[] args) {
        if (args == null || args.length < 2) {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        taskManager.updateStatus(id, taskFactory.getTaskStatus(args[1]));
        return new CommandResponseDTO("ok");
    }

    @Override
    public CommandName getName() {
        return CommandName.CHANGE_STATUS;
    }

    @Override
    public String getDescription() {
        return "{id} change command status";
    }

}

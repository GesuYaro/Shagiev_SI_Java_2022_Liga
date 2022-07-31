package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.dto.command.CommandResponseDTO;
import shagiev.homework2.dto.task.TaskInfoDTO;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.services.console.managers.TaskManager;

@RequiredArgsConstructor
@Component
public class ShowTaskCommand implements Command {

    private final TaskManager taskManager;

    @Override
    public CommandResponseDTO execute(String[] args) {
        CommandResponseDTO response = new CommandResponseDTO();
        if (args == null || args.length < 1) {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        for (Task task : taskManager.getTasks(id)) {
            response.addTask(new TaskInfoDTO(
                    task.getId(),
                    task.getHeader(),
                    task.getDescription(),
                    task.getDate(),
                    task.getStatus(),
                    task.getUser().getId()
            ));
        }
        return response;
    }

    @Override
    public CommandName getName() {
        return CommandName.SHOW_TASKS;
    }

    @Override
    public String getDescription() {
        return "{id} show tasks for user";
    }

}

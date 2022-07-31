package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.dto.command.CommandResponseDto;
import shagiev.homework2.dto.task.TaskInfoDto;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;
import shagiev.homework2.services.console.managers.TaskFactory;
import shagiev.homework2.services.console.managers.TaskManager;

import java.util.List;

@RequiredArgsConstructor
@Component
public class FilterByStatusCommand implements Command {

    private final TaskFactory taskFactory;
    private final TaskManager taskManager;

    @Override
    public CommandResponseDto execute(String[] args) {
        CommandResponseDto response = new CommandResponseDto();
        if (args == null || args.length < 2) {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        TaskStatus status = taskFactory.getTaskStatus(args[1]);
        List<Task> tasks = taskManager.getTasksByStatus(id, status);
        for (Task task : tasks) {
            response.addTask(new TaskInfoDto(
                    task.getId(),
                    task.getHeader(),
                    task.getDescription(),
                    task.getDate(),
                    task.getStatus(),
                    task.getUser().getId()));
        }
        response.setMessage("ok");
        return response;
    }

    @Override
    public CommandName getName() {
        return CommandName.FILTER_BY_STATUS;
    }

    @Override
    public String getDescription() {
        return "{id} show user's tasks filtered by status";
    }

}

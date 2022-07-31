package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.dto.command.CommandResponseDto;
import shagiev.homework2.dto.task.TaskInfoDto;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.services.console.managers.TaskManager;

@RequiredArgsConstructor
@Component
public class ShowTaskCommand implements Command {

    private final TaskManager taskManager;

    @Override
    public CommandResponseDto execute(String[] args) {
        CommandResponseDto response = new CommandResponseDto();
        if (args == null || args.length < 1) {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        for (Task task : taskManager.getTasks(id)) {
            response.addTask(new TaskInfoDto(
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

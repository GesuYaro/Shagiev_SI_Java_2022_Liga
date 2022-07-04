package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;
import shagiev.homework2.services.console.managers.TaskFactory;
import shagiev.homework2.services.console.managers.TaskManager;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@RequiredArgsConstructor
@Component
public class FilterByStatusCommand implements Command {

    private final TaskFactory taskFactory;
    private final TaskManager taskManager;
    private final String description = "{id} show user's tasks filtered by status";
    private final Writer writer;

    @Override
    public boolean execute(String[] args) {
        if (args == null || args.length < 1) {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        try {
            TaskStatus status = taskFactory.getTaskStatus(args[0]);
            List<Task> tasks = taskManager.getTasksByStatus(id, status);
            for (Task task: tasks) {
                writer.write(task.toString());
                writer.write("\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.err.println("Problem with reading");
        }
        return false;
    }

    @Override
    public String getName() {
        return "filter_by_status";
    }

    @Override
    public String getDescription() {
        return description;
    }

}

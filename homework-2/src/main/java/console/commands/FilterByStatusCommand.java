package console.commands;

import lombok.RequiredArgsConstructor;
import task.InteractiveTaskBuilder;
import task.Task;
import task.TaskStatus;
import task.manager.TaskManager;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@RequiredArgsConstructor
public class FilterByStatusCommand implements Command {

    private final InteractiveTaskBuilder taskBuilder;
    private final TaskManager taskManager;
    private final String description = "{id} show user's tasks filtered by status";
    private final Writer writer;

    @Override
    public boolean invoke(String[] args) {
        if (args == null || args.length < 1) {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        try {
            TaskStatus status = taskBuilder.getTaskStatus();
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
    public String getDescription() {
        return description;
    }

}

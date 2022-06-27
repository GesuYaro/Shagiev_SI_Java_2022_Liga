package console.commands;

import lombok.RequiredArgsConstructor;
import task.TaskBuilder;
import task.manager.TaskManager;

import java.io.IOException;

@RequiredArgsConstructor
public class UpdateTaskCommand implements Command {

    private final String description = "{id} update task";
    private final TaskManager taskManager;
    private final TaskBuilder taskBuilder;

    @Override
    public boolean invoke(String[] args) {
        if (args == null || args.length < 1) {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        try {
            taskManager.updateTask(id, taskBuilder.getTask());
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

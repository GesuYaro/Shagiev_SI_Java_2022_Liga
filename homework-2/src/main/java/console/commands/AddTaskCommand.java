package console.commands;

import lombok.RequiredArgsConstructor;
import task.TaskBuilder;
import task.manager.TaskManager;

import java.io.IOException;

@RequiredArgsConstructor
public class AddTaskCommand implements Command {

    private final String description = "add new task";
    private final TaskBuilder taskBuilder;
    private final TaskManager taskManager;

    @Override
    public boolean invoke(String[] args) {
        try {
            taskManager.addTask(taskBuilder.getTask());
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

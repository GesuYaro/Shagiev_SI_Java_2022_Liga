package console.commands;

import lombok.RequiredArgsConstructor;
import task.InteractiveTaskBuilder;
import task.manager.TaskManager;

import java.io.IOException;

@RequiredArgsConstructor
public class ChangeStatusCommand implements Command {

    private final String description = "{id} change command status";
    private final TaskManager taskManager;
    private final InteractiveTaskBuilder taskBuilder;

    @Override
    public boolean invoke(String[] args) {
        if (args == null || args.length < 1) {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        try {
            taskManager.updateStatus(id, taskBuilder.getTaskStatus());
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

package console.commands;

import lombok.RequiredArgsConstructor;
import task.Task;
import task.manager.TaskManager;

import java.io.IOException;
import java.io.Writer;

@RequiredArgsConstructor
public class ShowTaskCommand implements Command {

    private final String description = "{id} show tasks for user";
    private final TaskManager taskManager;
    private final Writer writer;

    @Override
    public boolean invoke(String[] args) {
        if (args == null || args.length < 1) {
            throw new NotEnoughArgumentsException();
        }
        try {
            int id = Integer.parseInt(args[0]);
            for (Task task: taskManager.getTasks(id)) {
                writer.write(task.toString());
                writer.write("\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.err.println("Problem with printing");
        }
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }

}

package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.services.console.managers.TaskManager;

import java.io.IOException;
import java.io.Writer;

@RequiredArgsConstructor
@Component
public class ShowTaskCommand implements Command {

    private final TaskManager taskManager;
    private final Writer writer;

    @Override
    public boolean execute(String[] args) {
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
    public CommandName getName() {
        return CommandName.SHOW_TASKS;
    }

    @Override
    public String getDescription() {
        return "{id} show tasks for user";
    }

}

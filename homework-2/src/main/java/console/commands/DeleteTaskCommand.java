package console.commands;

import lombok.RequiredArgsConstructor;
import task.manager.TaskManager;

@RequiredArgsConstructor
public class DeleteTaskCommand implements Command{

    private final String description = "{id} delete task";
    private final TaskManager taskManager;

    @Override
    public boolean invoke(String[] args) {
        if (args == null || args.length < 1)  {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        taskManager.delete(id);
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }

}

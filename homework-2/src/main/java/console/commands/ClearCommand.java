package console.commands;

import lombok.RequiredArgsConstructor;
import task.manager.TaskManager;
import user.manager.UserManager;

@RequiredArgsConstructor
public class ClearCommand implements Command {

    private final TaskManager taskManager;
    private final UserManager userManager;
    private final String description = "{id} clear tasks for user, or all data if id is not provided";

    @Override
    public boolean invoke(String[] args) {
        if (args == null || args.length < 1) {
            userManager.clear();
            taskManager.clearAll();
            return false;
        }
        int id = Integer.parseInt(args[0]);
        taskManager.clear(id);
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }

}

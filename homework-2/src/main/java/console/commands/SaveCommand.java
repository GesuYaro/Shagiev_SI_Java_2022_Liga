package console.commands;

import file.writer.ObjectPrinter;
import lombok.RequiredArgsConstructor;
import task.manager.TaskManager;
import user.manager.UserManager;

import java.io.IOException;

@RequiredArgsConstructor
public class SaveCommand implements Command {

    private final ObjectPrinter taskPrinter;
    private final ObjectPrinter userPrinter;
    private final TaskManager taskManager;
    private final UserManager userManager;
    private final String description = "save all data to file";

    @Override
    public boolean invoke(String[] args) {
        try {
            userPrinter.writeObjects(userManager.getUsers());
            taskPrinter.writeObjects(taskManager.getAllTasks());
        } catch (IOException e) {
            System.err.print("Can't save objects. ");
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }

}

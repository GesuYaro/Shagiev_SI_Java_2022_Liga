package shagiev.homework2.services.console.managers;



import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;

import java.util.List;

public interface TaskManager {

    List<Task> getTasks(int userId);
    List<Task> getAllTasks();
    List<Task> getTasksByStatus(int userId, TaskStatus status);
    void addTask(Task task);
    void clear(int userId);
    void clearAll();
    void delete(int id);
    void updateTask(int id, Task task);
    void updateStatus(int id, TaskStatus status);

}

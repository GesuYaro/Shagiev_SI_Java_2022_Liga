package task.manager;

import task.Task;
import task.TaskStatus;

import java.util.List;

public interface TaskManager {

    List<Task> getTasks(int userId);
    List<Task> getTasksByStatus(int userId, TaskStatus status);
    List<Task> getTasksOrderedByDate(int userId);
    void addTask(Task task);
    void clear(int userId);
    void clearAll();
    void delete(int id);
    void updateTask(int id, Task task);
    void updateStatus(int id, TaskStatus status);

}

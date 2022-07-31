package shagiev.homework2.services.console.managers;



import shagiev.homework2.dto.task.TaskRequestDto;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;

import java.util.List;

public interface TaskManager {

    List<Task> getTasks(int userId);
    List<Task> getAllTasks();
    List<Task> getTasksByStatus(int userId, TaskStatus status);
    void addTask(TaskRequestDto task);
    void clear(int userId);
    void clearAll();
    void delete(int id);
    void updateTask(int id, TaskRequestDto task);
    void updateStatus(int id, TaskStatus status);

}

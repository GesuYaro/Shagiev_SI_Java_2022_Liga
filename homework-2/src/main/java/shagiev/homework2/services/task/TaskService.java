package shagiev.homework2.services.task;

import shagiev.homework2.dto.task.TaskRequestDTO;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;

import java.util.Date;
import java.util.List;

public interface TaskService {

    List<Task> getTasksByUserId(int userId);
    List<Task> getAllTasks();
    List<Task> getTasksByUserIdAndStatus(int userId, TaskStatus status);
    Task getTaskById(int id);
    Task save(TaskRequestDTO task);
    void deleteByUserId(int userId);
    void clear();
    void deleteById(int id);
    void updateStatus(int id, TaskStatus status);

    int updateTask(int id, String header, String description, Date date, TaskStatus taskStatus, int userId);

}

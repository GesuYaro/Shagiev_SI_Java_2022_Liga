package shagiev.homework2.services.console.managers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shagiev.homework2.dto.task.TaskRequestDTO;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;
import shagiev.homework2.services.task.TaskService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService2TaskManagerAdapter implements TaskManager {

    private final TaskService taskService;

    @Override
    public List<Task> getTasks(int userId) {
        return taskService.getTasksByUserId(userId);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @Override
    public List<Task> getTasksByStatus(int userId, TaskStatus status) {
        return taskService.getTasksByUserIdAndStatus(userId, status);
    }

    @Override
    public void addTask(TaskRequestDTO task) {
        taskService.save(task);
    }

    @Override
    public void clear(int userId) {
        taskService.deleteByUserId(userId);
    }

    @Override
    public void clearAll() {
        taskService.clear();
    }

    @Override
    public void delete(int id) {
        taskService.deleteById(id);
    }

    @Override
    public void updateTask(int id, TaskRequestDTO task) {
        taskService.updateTask(id, task.getHeader(), task.getDescription(), task.getDate(), task.getStatus(), task.getUserId());
    }

    @Override
    public void updateStatus(int id, TaskStatus status) {
        taskService.updateStatus(id, status);
    }

}

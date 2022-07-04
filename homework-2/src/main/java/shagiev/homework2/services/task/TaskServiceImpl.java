package shagiev.homework2.services.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;
import shagiev.homework2.repos.TaskRepo;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    @Override
    public List<Task> getTasksByUserId(int userId) {
        return taskRepo.findAllByUserId(userId);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public List<Task> getTasksByUserIdAndStatus(int userId, TaskStatus status) {
        return taskRepo.findAllByUserIdAndStatus(userId, status);
    }

    @Transactional
    @Override
    public void save(Task task) {
        taskRepo.save(task);
    }

    @Transactional
    @Override
    public void deleteByUserId(int userId) {
        taskRepo.deleteAllByUserId(userId);
    }

    @Transactional
    @Override
    public void clear() {
        taskRepo.deleteAll();
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        taskRepo.deleteById(id);
    }

    @Transactional
    @Override
    public void updateStatus(int id, TaskStatus status) {
        taskRepo.updateStatusById(id, status);
    }

    @Override
    public void updateTask(int id, String header, String description, Date date, TaskStatus taskStatus, int userId) {
        taskRepo.updateTaskById(id, header, description, date, taskStatus, userId);
    }

}

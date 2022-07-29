package shagiev.homework2.services.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shagiev.homework2.dto.task.TaskRequestDTO;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;
import shagiev.homework2.model.user.User;
import shagiev.homework2.repos.TaskRepo;
import shagiev.homework2.repos.UserRepo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;
    private final UserRepo userRepo;

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
    public Task save(TaskRequestDTO taskRequestDTO) {
        Optional<User> userOptional = userRepo.findById(taskRequestDTO.getUserId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return taskRepo.save(new Task(0, taskRequestDTO.getHeader(),
                    taskRequestDTO.getDescription(), taskRequestDTO.getDate(), taskRequestDTO.getStatus(), user));
        } else {
            return null;
        }
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

    @Transactional
    @Override
    public int updateTask(int id, String header, String description, Date date, TaskStatus taskStatus, int userId) {
        Optional<User> user = userRepo.findById(userId);
        if (user.isPresent()) {
            return taskRepo.updateTaskById(id, header, description, date, taskStatus, user.get());
        } else {
            return 0;
        }
    }

    @Override
    public Task getTaskById(int id) {
        Optional<Task> task = taskRepo.findById(id);
        return task.orElse(null);
    }

}

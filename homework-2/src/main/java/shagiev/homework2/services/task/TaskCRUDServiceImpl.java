package shagiev.homework2.services.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shagiev.homework2.dto.task.TaskInfoDTO;
import shagiev.homework2.dto.task.TaskRequestDTO;
import shagiev.homework2.model.task.Task;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskCRUDServiceImpl implements TaskCRUDService {

    private final TaskService taskService;
    private final TaskDTOConverter taskDTOConverter;

    @Override
    public List<TaskInfoDTO> getAll() {
        List<Task> tasks = taskService.getAllTasks();
        return taskDTOConverter.toTaskInfoDTOList(tasks);
    }

    @Override
    public TaskInfoDTO getConcrete(int id) {
        Task task = taskService.getTaskById(id);
        if (task != null) {
            return taskDTOConverter.toTaskInfoDTO(task);
        } else {
            return null;
        }
    }

    @Override
    public TaskInfoDTO save(TaskRequestDTO taskRequestDTO) {
        Task task = taskService.save(taskRequestDTO);
        return taskDTOConverter.toTaskInfoDTO(task);
    }

    @Override
    public int update(int id, TaskRequestDTO taskRequestDTO) {
        return taskService.updateTask(id, taskRequestDTO.getHeader(),
                taskRequestDTO.getDescription(), taskRequestDTO.getDate(),
                taskRequestDTO.getStatus(), taskRequestDTO.getUserId());
    }

    @Override
    public void delete(int id) {
        taskService.deleteById(id);
    }

    @Override
    public List<TaskInfoDTO> getByUserId(int id) {
        List<Task> tasks = taskService.getTasksByUserId(id);
        return taskDTOConverter.toTaskInfoDTOList(tasks);
    }

}

package shagiev.homework2.services.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shagiev.homework2.dto.task.TaskInfoDto;
import shagiev.homework2.dto.task.TaskRequestDto;
import shagiev.homework2.model.task.Task;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskCrudServiceImpl implements TaskCrudService {

    private final TaskService taskService;
    private final TaskDtoConverter taskDTOConverter;

    @Override
    public List<TaskInfoDto> getAll() {
        List<Task> tasks = taskService.getAllTasks();
        return taskDTOConverter.toTaskInfoDtoList(tasks);
    }

    @Override
    public TaskInfoDto getConcrete(int id) {
        Task task = taskService.getTaskById(id);
        if (task != null) {
            return taskDTOConverter.toTaskInfoDto(task);
        } else {
            return null;
        }
    }

    @Override
    public TaskInfoDto save(TaskRequestDto taskRequestDTO) {
        Task task = taskService.save(taskRequestDTO);
        return taskDTOConverter.toTaskInfoDto(task);
    }

    @Override
    public int update(int id, TaskRequestDto taskRequestDTO) {
        return taskService.updateTask(id, taskRequestDTO.getHeader(),
                taskRequestDTO.getDescription(), taskRequestDTO.getDate(),
                taskRequestDTO.getStatus(), taskRequestDTO.getUserId());
    }

    @Override
    public void delete(int id) {
        taskService.deleteById(id);
    }

    @Override
    public List<TaskInfoDto> getByUserId(int id) {
        List<Task> tasks = taskService.getTasksByUserId(id);
        return taskDTOConverter.toTaskInfoDtoList(tasks);
    }

}

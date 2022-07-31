package shagiev.homework2.services.task;

import org.springframework.stereotype.Service;
import shagiev.homework2.dto.task.TaskInfoDto;
import shagiev.homework2.model.task.Task;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskDtoConverterImpl implements TaskDtoConverter {

    @Override
    public List<TaskInfoDto> toTaskInfoDtoList(List<Task> tasks) {
        List<TaskInfoDto> dtos = new ArrayList<>();
        for (Task task : tasks) {
            dtos.add(toTaskInfoDto(task));
        }
        return dtos;
    }

    @Override
    public TaskInfoDto toTaskInfoDto(Task task) {
        return new TaskInfoDto(task.getId(), task.getHeader(), task.getDescription(),
                task.getDate(), task.getStatus(),
                task.getUser() != null ? task.getUser().getId() : 0);
    }

}

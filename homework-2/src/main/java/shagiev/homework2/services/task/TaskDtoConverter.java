package shagiev.homework2.services.task;

import shagiev.homework2.dto.task.TaskInfoDto;
import shagiev.homework2.model.task.Task;

import java.util.List;

public interface TaskDtoConverter {

    List<TaskInfoDto> toTaskInfoDtoList(List<Task> tasks);
    TaskInfoDto toTaskInfoDto(Task task);

}

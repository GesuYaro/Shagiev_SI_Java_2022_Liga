package shagiev.homework2.services.task;

import shagiev.homework2.dto.task.TaskInfoDTO;
import shagiev.homework2.model.task.Task;

import java.util.List;

public interface TaskDTOConverter {

    List<TaskInfoDTO> toTaskInfoDTOList(List<Task> tasks);
    TaskInfoDTO toTaskInfoDTO(Task task);

}

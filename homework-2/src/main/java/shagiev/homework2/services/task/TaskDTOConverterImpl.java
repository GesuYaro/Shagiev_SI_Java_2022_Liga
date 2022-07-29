package shagiev.homework2.services.task;

import org.springframework.stereotype.Service;
import shagiev.homework2.dto.task.TaskInfoDTO;
import shagiev.homework2.model.task.Task;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskDTOConverterImpl implements TaskDTOConverter {

    @Override
    public List<TaskInfoDTO> toTaskInfoDTOList(List<Task> tasks) {
        List<TaskInfoDTO> dtos = new ArrayList<>();
        for (Task task : tasks) {
            dtos.add(toTaskInfoDTO(task));
        }
        return dtos;
    }

    @Override
    public TaskInfoDTO toTaskInfoDTO(Task task) {
        return new TaskInfoDTO(task.getId(), task.getHeader(), task.getDescription(),
                task.getDate(), task.getStatus(),
                task.getUser() != null ? task.getUser().getId() : 0);
    }

}

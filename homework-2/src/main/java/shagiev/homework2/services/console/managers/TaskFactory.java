package shagiev.homework2.services.console.managers;

import shagiev.homework2.dto.task.TaskRequestDTO;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;

public interface TaskFactory {

    TaskRequestDTO getTask(String id, String header, String description,
                           String date, String status, String userId);

    TaskStatus getTaskStatus(String string);

}

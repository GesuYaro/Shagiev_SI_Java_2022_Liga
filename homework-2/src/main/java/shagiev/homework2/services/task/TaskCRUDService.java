package shagiev.homework2.services.task;

import shagiev.homework2.dto.task.TaskInfoDTO;
import shagiev.homework2.dto.task.TaskRequestDTO;

import java.util.List;

public interface TaskCRUDService {

    List<TaskInfoDTO> getAll();
    TaskInfoDTO getConcrete(int id);
    TaskInfoDTO save(TaskRequestDTO taskRequestDTO);
    int update(int id, TaskRequestDTO taskRequestDTO);
    void delete(int id);

}

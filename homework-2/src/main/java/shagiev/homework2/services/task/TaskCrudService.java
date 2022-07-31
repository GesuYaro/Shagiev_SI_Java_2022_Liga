package shagiev.homework2.services.task;

import shagiev.homework2.dto.task.TaskInfoDto;
import shagiev.homework2.dto.task.TaskRequestDto;

import java.util.List;

public interface TaskCrudService {

    List<TaskInfoDto> getAll();
    TaskInfoDto getConcrete(int id);
    TaskInfoDto save(TaskRequestDto taskRequestDTO);
    int update(int id, TaskRequestDto taskRequestDTO);
    void delete(int id);
    List<TaskInfoDto> getByUserId(int id);

}

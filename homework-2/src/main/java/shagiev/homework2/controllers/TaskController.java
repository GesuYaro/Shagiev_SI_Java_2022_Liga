package shagiev.homework2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shagiev.homework2.dto.task.TaskInfoDto;
import shagiev.homework2.dto.task.TaskRequestDto;
import shagiev.homework2.services.task.TaskCrudService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskCrudService taskCrudService;

    @GetMapping
    public List<TaskInfoDto> getTasks() {
        return taskCrudService.getAll();
    }

    @GetMapping("/{id}")
    public TaskInfoDto getTask(@PathVariable int id) {
        return taskCrudService.getConcrete(id);
    }

    @PostMapping
    public TaskInfoDto saveTask(@RequestBody TaskRequestDto taskRequestDTO) {
        return taskCrudService.save(taskRequestDTO);
    }

    @PutMapping("/{id}")
    public int updateTask(@PathVariable int id, @RequestBody TaskRequestDto taskRequestDTO) {
        return taskCrudService.update(id, taskRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        taskCrudService.delete(id);
    }

}

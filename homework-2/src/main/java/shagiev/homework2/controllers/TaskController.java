package shagiev.homework2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shagiev.homework2.dto.task.TaskInfoDTO;
import shagiev.homework2.dto.task.TaskRequestDTO;
import shagiev.homework2.services.task.TaskCRUDService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskCRUDService taskCRUDService;

    @GetMapping
    public List<TaskInfoDTO> getTasks() {
        return taskCRUDService.getAll();
    }

    @GetMapping("/{id}")
    public TaskInfoDTO getTask(@PathVariable int id) {
        return taskCRUDService.getConcrete(id);
    }

    @PostMapping
    public TaskInfoDTO saveTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        return taskCRUDService.save(taskRequestDTO);
    }

    @PutMapping("/{id}")
    public int updateTask(@PathVariable int id, @RequestBody TaskRequestDTO taskRequestDTO) {
        return taskCRUDService.update(id, taskRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        taskCRUDService.delete(id);
    }

}

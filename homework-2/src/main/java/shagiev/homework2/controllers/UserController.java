package shagiev.homework2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shagiev.homework2.dto.task.TaskInfoDto;
import shagiev.homework2.dto.user.UserInfoDto;
import shagiev.homework2.dto.user.UserRequestDto;
import shagiev.homework2.services.user.UserCrudService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserCrudService userCrudService;

    @GetMapping
    public List<UserInfoDto> getUsers() {
        return userCrudService.getAll();
    }

    @GetMapping("/{id}")
    public UserInfoDto getUser(@PathVariable int id) {
        return userCrudService.getConcrete(id);
    }

    @PostMapping
    public UserInfoDto saveUser(@RequestBody UserRequestDto userRequestDto) {
        return userCrudService.save(userRequestDto);
    }

    @PutMapping("/{id}")
    public int updateUser(@PathVariable int id, @RequestBody UserRequestDto userRequestDto) {
        return userCrudService.update(id, userRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userCrudService.delete(id);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskInfoDto> getUserTasks(@PathVariable int id) {
        return userCrudService.getUserTasks(id);
    }

}

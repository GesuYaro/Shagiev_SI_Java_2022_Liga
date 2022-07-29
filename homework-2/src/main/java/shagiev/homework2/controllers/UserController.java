package shagiev.homework2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shagiev.homework2.dto.user.UserInfoDTO;
import shagiev.homework2.dto.user.UserRequestDTO;
import shagiev.homework2.services.user.UserCRUDService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserCRUDService userCRUDService;

    @GetMapping
    public List<UserInfoDTO> getUsers() {
        return userCRUDService.getAll();
    }

    @GetMapping("/{id}")
    public UserInfoDTO getUser(@PathVariable int id) {
        return userCRUDService.getConcrete(id);
    }

    @PostMapping
    public UserInfoDTO saveUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userCRUDService.save(userRequestDTO);
    }

    @PutMapping("/{id}")
    public int updateUser(@PathVariable int id, @RequestBody UserRequestDTO userRequestDTO) {
        return userCRUDService.update(id, userRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userCRUDService.delete(id);
    }

}

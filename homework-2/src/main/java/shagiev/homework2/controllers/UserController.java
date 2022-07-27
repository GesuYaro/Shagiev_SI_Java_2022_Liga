package shagiev.homework2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shagiev.homework2.dto.user.UserInfoDTO;
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

}

package shagiev.homework2.services.console.managers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shagiev.homework2.dto.user.UserRequestDTO;
import shagiev.homework2.model.user.User;
import shagiev.homework2.services.user.UserService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService2UserManagerAdapter implements UserManager {

    private final UserService userService;

    @Override
    public void addUser(UserRequestDTO user) {
        userService.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userService.deleteUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userService.getAll();
    }

    @Override
    public void updateUser(int id, UserRequestDTO user) {
        userService.updateName(id, user.getName());
    }

    @Override
    public void clear() {
        userService.clear();
    }

}

package shagiev.homework2.services.console.managers;

import shagiev.homework2.dto.user.UserRequestDto;
import shagiev.homework2.model.user.User;

import java.util.List;

public interface UserManager {

    void addUser(UserRequestDto user);
    void deleteUser(int id);
    List<User> getUsers();
    void updateUser(int id, UserRequestDto user);
    void clear();

}

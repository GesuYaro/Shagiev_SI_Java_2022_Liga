package shagiev.homework2.services.console.managers;

import shagiev.homework2.dto.user.UserRequestDTO;
import shagiev.homework2.model.user.User;

import java.util.List;

public interface UserManager {

    void addUser(UserRequestDTO user);
    void deleteUser(int id);
    List<User> getUsers();
    void updateUser(int id, UserRequestDTO user);
    void clear();

}

package shagiev.homework2.services.user;

import shagiev.homework2.dto.user.UserRequestDTO;
import shagiev.homework2.model.user.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    void save(UserRequestDTO user);
    void updateName(int id, String name);
    void deleteUser(int id);
    void clear();

}

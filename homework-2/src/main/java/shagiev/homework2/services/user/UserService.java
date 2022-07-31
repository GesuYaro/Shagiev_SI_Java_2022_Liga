package shagiev.homework2.services.user;

import shagiev.homework2.dto.user.UserRequestDto;
import shagiev.homework2.model.user.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User getConcrete(int id);
    User save(UserRequestDto user);
    int updateName(int id, String name);
    void deleteUser(int id);
    void clear();

}

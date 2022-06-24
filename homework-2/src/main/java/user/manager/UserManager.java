package user.manager;

import user.User;

import java.util.List;

public interface UserManager {

    void addUser(User user);
    void deleteUser(int id);
    List<User> getUsers();
    void updateUser(int id, User user);

}

package user.manager;

import user.User;

import java.util.List;
import java.util.ListIterator;

public class HeapUserManager implements UserManager {

    private final List<User> userList;
    private int biggestId;

    public HeapUserManager(List<User> userList) {
        this.userList = userList;
        if (!userList.isEmpty()) {
            biggestId = findBiggestId(userList);
        } else {
            biggestId = 0;
        }
    }

    private static int findBiggestId(List<User> userList) {
        return userList.stream()
                .max((user1, user2) -> Integer.compare(user1.getId(), user2.getId()))
                .orElseThrow()
                .getId();
    }

    @Override
    public void addUser(User user) {
        int newId = ++biggestId;
        user.setId(newId);
        userList.add(user);
    }

    @Override
    public void deleteUser(int id) {
        userList.removeIf(user -> user.getId() == id);
    }

    @Override
    public List<User> getUsers() {
        return userList;
    }

    @Override
    public void updateUser(int id, User user) {
        user.setId(id);
        for (ListIterator<User> it = userList.listIterator(); it.hasNext(); ) {
            if (it.next().getId() == id) {
                it.set(user);
            }
        }
    }

    @Override
    public void clear() {
        userList.clear();
    }

}

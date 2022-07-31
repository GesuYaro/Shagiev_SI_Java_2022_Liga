package shagiev.homework2.services.console.managers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shagiev.homework2.dto.user.UserRequestDto;
import shagiev.homework2.model.user.User;
import shagiev.homework2.services.user.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserService2UserManagerAdapterTest {

    UserService userServiceMock = Mockito.mock(UserService.class);
    UserService2UserManagerAdapter userManagerAdapter = new UserService2UserManagerAdapter(userServiceMock);

    @Test
    void addUser_validUser() {
        UserRequestDto user = getValidUser();
        userManagerAdapter.addUser(user);
        Mockito.verify(userServiceMock).save(user);
    }

    @Test
    void deleteUser_validId() {
        int id = 1;
        userManagerAdapter.deleteUser(id);
        Mockito.verify(userServiceMock).deleteUser(1);
    }

    @Test
    void getUsers_validList() {
        Mockito.when(userServiceMock.getAll()).thenReturn(getUserList());
        assertEquals(getUserList(), userManagerAdapter.getUsers());
    }

    @Test
    void getUsers_emptyList() {
        Mockito.when(userServiceMock.getAll()).thenReturn(getEmptyList());
        assertEquals(getEmptyList(), userManagerAdapter.getUsers());
    }

    @Test
    void updateUser() {
        UserRequestDto user = getValidUser();
        userManagerAdapter.updateUser(1, user);
        Mockito.verify(userServiceMock).updateName(1, user.getName());
    }

    @Test
    void clear() {
        userManagerAdapter.clear();
        Mockito.verify(userServiceMock).clear();
    }

    List<User> getUserList() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Test1", null));
        users.add(new User(2, "Test2", null));
        users.add(new User(3, "Test3", null));
        users.add(new User(4, "Test4", null));
        users.add(new User(5, "Test5", null));
        return users;
    }

    List<User> getEmptyList() {
        return new ArrayList<>();
    }

    UserRequestDto getValidUser() {
       return new UserRequestDto("Test1");
    }
}
package shagiev.homework2.services.console.commands;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shagiev.homework2.model.user.User;
import shagiev.homework2.services.console.managers.UserManager;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShowUsersCommandTest {

    UserManager userManagerMock = Mockito.mock(UserManager.class);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    Writer writer = new OutputStreamWriter(byteArrayOutputStream);
    ShowUsersCommand command = new ShowUsersCommand(userManagerMock, writer);

    {
        Mockito.when(userManagerMock.getUsers()).thenReturn(getUsers());
    }

    @Test
    void execute_anyArguments_validBehaviour() {
        boolean result = command.execute(getAnyArgs());
        String message = byteArrayOutputStream.toString();
        assertEquals(getValidMessage(), message);
        assertFalse(result);
    }


    String[] getAnyArgs() {
        return "test test".split(" ");
    }

    List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Test1"));
        users.add(new User(2, "Test2"));
        users.add(new User(9, "Test9"));
        users.add(new User(99, "Test99"));
        users.add(new User(778, "Test778"));
        return users;
    }

    private String getValidMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        for (User user: getUsers()) {
            stringBuilder.append(user.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}

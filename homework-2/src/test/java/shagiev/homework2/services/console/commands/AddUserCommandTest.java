package shagiev.homework2.services.console.commands;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;
import shagiev.homework2.model.user.User;
import shagiev.homework2.services.console.managers.UserFactory;
import shagiev.homework2.services.console.managers.UserManager;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class AddUserCommandTest {

    UserManager userManagerMock = Mockito.mock(UserManager.class);
    UserFactory userFactoryMock = Mockito.mock(UserFactory.class);
    AddUserCommand command = new AddUserCommand(userFactoryMock, userManagerMock);

    {
        String[] validArgs = getValidArgs();
        Mockito.when(userFactoryMock.getUser(eq(validArgs[0]))).thenReturn(getValidUser());
    }

    @Test
    void execute_validArgs_validBehaviour() {
        boolean result = command.execute(getValidArgs());
        Mockito.verify(userManagerMock).addUser(getValidUser());
        assertFalse(result);
    }

    @Test
    void execute_notEnoughArguments_throwsException() {
        assertThrows(NotEnoughArgumentsException.class, () -> command.execute(getNotEnoughArgs()));
    }

    String[] getValidArgs() {
        return "Test".split(" ");
    }

    User getValidUser() {
        return new User(1, "Test");
    }

    String[] getNotEnoughArgs() {
        return new String[]{};
    }

}
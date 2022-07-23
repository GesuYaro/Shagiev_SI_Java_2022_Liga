package shagiev.homework2.services.console.commands;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shagiev.homework2.dto.user.UserRequestDTO;
import shagiev.homework2.model.user.User;
import shagiev.homework2.services.console.managers.UserFactory;
import shagiev.homework2.services.console.managers.UserManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;

class UpdateUserCommandTest {

    UserManager userManagerMock = Mockito.mock(UserManager.class);
    UserFactory userFactoryMock = Mockito.mock(UserFactory.class);
    UpdateUserCommand command = new UpdateUserCommand(userManagerMock, userFactoryMock);

    {
        String[] validArgs = getValidArgs();
        Mockito.when(userFactoryMock.getUser(validArgs[1])).thenReturn(getValidUser());
    }

    @Test
    void execute_validArgs_validBehaviour() {
        boolean result = command.execute(getValidArgs());
        Mockito.verify(userManagerMock).updateUser(getValidId(), getValidUser());
        assertFalse(result);
    }

    @Test
    void execute_notEnoughArguments_throwsException() {
        assertThrows(NotEnoughArgumentsException.class, () -> command.execute(getNotEnoughArgs()));
    }

    String[] getValidArgs() {
        return "1 Test".split(" ");
    }

    UserRequestDTO getValidUser() {
        return new UserRequestDTO(1, "Test");
    }

    int getValidId() {
        return 1;
    }

    String[] getNotEnoughArgs() {
        return new String[]{"1"};
    }
}
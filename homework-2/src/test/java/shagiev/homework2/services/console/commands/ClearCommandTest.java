package shagiev.homework2.services.console.commands;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shagiev.homework2.services.console.managers.TaskManager;
import shagiev.homework2.services.console.managers.UserManager;

import static org.junit.jupiter.api.Assertions.*;

class ClearCommandTest {

    UserManager userManagerMock = Mockito.mock(UserManager.class);
    TaskManager taskManagerMock = Mockito.mock(TaskManager.class);
    ClearCommand command = new ClearCommand(taskManagerMock, userManagerMock);

    @Test
    void execute_noArguments_clearAll() {
        command.execute(new String[]{});
        Mockito.verify(userManagerMock).clear();
        Mockito.verify(taskManagerMock).clearAll();
    }

    @Test
    void execute_oneArgument_clearOnlyUserTasks() {
        command.execute(getValidArgs());
        Mockito.verify(taskManagerMock).clear(getValidId());
    }

    @Test
    void execute_invalidArgument_throwsException() {
        assertThrows(NumberFormatException.class, () -> command.execute(getInvalidArgs()));
    }

    String[] getValidArgs() {
        return "1".split(" ");
    }

    int getValidId() {
        return 1;
    }

    String[] getInvalidArgs() {
        return "test".split(" ");
    }
}
package shagiev.homework2.services.console.commands;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shagiev.homework2.services.console.managers.TaskManager;

import static org.junit.jupiter.api.Assertions.*;

class DeleteTaskCommandTest {

    TaskManager taskManagerMock = Mockito.mock(TaskManager.class);
    DeleteTaskCommand command = new DeleteTaskCommand(taskManagerMock);

    @Test
    void execute_validArguments_validBehaviour() {
        command.execute(getValidArgs());
        Mockito.verify(taskManagerMock).delete(getValidId());
    }

    @Test
    void execute_notEnoughArguments_throwsException() {
        assertThrows(NotEnoughArgumentsException.class, () -> command.execute(getNotEnoughArgs()));
    }

    @Test
    void execute_invalidArguments_throwsException() {
        assertThrows(NumberFormatException.class, () -> command.execute(getInvalidArgs()));
    }

    String[] getValidArgs() {
        return "1".split(" ");
    }

    int getValidId() {
        return 1;
    }

    String[] getNotEnoughArgs() {
        return new String[]{};
    }

    String[] getInvalidArgs() {
        return "test".split(" ");
    }
}
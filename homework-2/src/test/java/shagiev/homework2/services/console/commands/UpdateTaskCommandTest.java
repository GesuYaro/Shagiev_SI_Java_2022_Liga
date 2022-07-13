package shagiev.homework2.services.console.commands;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;
import shagiev.homework2.services.console.managers.TaskFactory;
import shagiev.homework2.services.console.managers.TaskManager;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class UpdateTaskCommandTest {

    TaskFactory taskFactoryMock = Mockito.mock(TaskFactory.class);
    TaskManager taskManagerMock = Mockito.mock(TaskManager.class);
    UpdateTaskCommand command = new UpdateTaskCommand(taskManagerMock, taskFactoryMock);

    {
        String[] validArgs = getValidArgs();
        Mockito.when(taskFactoryMock.getTask(validArgs[0], validArgs[1],
                        validArgs[2], validArgs[3], validArgs[4], validArgs[5]))
                .thenReturn(getValidTask());
    }

    @Test
    void execute_validArgs_validBehaviour() {
        boolean result = command.execute(getValidArgs());
        Mockito.verify(taskManagerMock).updateTask(getValidId(), getValidTask());
        assertFalse(result);
    }

    @Test
    void execute_notEnoughArguments_throwsException() {
        assertThrows(NotEnoughArgumentsException.class, () -> command.execute(getNotEnoughArgs()));
    }

    String[] getValidArgs() {
        return "1 Test Testtestest 19.09.1980 done 2".split(" ");
    }

    int getValidId() {
        return getValidTask().getId();
    }

    Task getValidTask() {
        return new Task(1, "Test", "Testtestest", new GregorianCalendar(1980, Calendar.SEPTEMBER, 19).getTime(), TaskStatus.DONE, 2);
    }

    String[] getNotEnoughArgs() {
        return "1 Test testtest 19.09.1980".split(" ");
    }
}
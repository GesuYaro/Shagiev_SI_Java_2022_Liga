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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class ChangeStatusCommandTest {

    TaskFactory taskFactoryMock = Mockito.mock(TaskFactory.class);
    TaskManager taskManagerMock = Mockito.mock(TaskManager.class);
    ChangeStatusCommand command = new ChangeStatusCommand(taskManagerMock, taskFactoryMock);

    {
        String[] validArgs = getValidArgs();
        Mockito.when(taskFactoryMock.getTaskStatus(validArgs[1])).thenReturn(getValidStatus());
    }

    @Test
    void execute_validArgs_validBehaviour() {
        boolean result = command.execute(getValidArgs());
        Mockito.verify(taskManagerMock).updateStatus(1, TaskStatus.NEW);
        assertFalse(result);
    }

    @Test
    void execute_notEnoughArguments_throwsException() {
        assertThrows(NotEnoughArgumentsException.class, () -> command.execute(getNotEnoughArgs()));
    }

    String[] getValidArgs() {
        return "1 new".split(" ");
    }

    TaskStatus getValidStatus() {
        return TaskStatus.NEW;
    }

    String[] getNotEnoughArgs() {
        return new String[]{};
    }

}
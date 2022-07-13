package shagiev.homework2.services.console.commands;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;
import shagiev.homework2.services.console.managers.TaskFactory;
import shagiev.homework2.services.console.managers.TaskManager;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class AddTaskCommandTest {

    TaskFactory taskFactoryMock = Mockito.mock(TaskFactory.class);
    TaskManager taskManagerMock = Mockito.mock(TaskManager.class);
    AddTaskCommand command = new AddTaskCommand(taskFactoryMock, taskManagerMock);

    {
        String[] validArgs = getValidArgs();
        Mockito.when(taskFactoryMock.getTask(any(), eq(validArgs[0]), eq(validArgs[1]),
                        eq(validArgs[2]), eq(validArgs[3]), eq(validArgs[4])))
                .thenReturn(getValidTask());
    }

    @Test
    void execute_validArgs_validBehaviour() {
        boolean result = command.execute(getValidArgs());
        Mockito.verify(taskManagerMock).addTask(getValidTask());
        assertFalse(result);
    }

    @Test
    void execute_notEnoughArguments_throwsException() {
        assertThrows(NotEnoughArgumentsException.class, () -> command.execute(getNotEnoughArgs()));
    }

    String[] getValidArgs() {
        return "Test Testtestest 19.09.1980 done 2".split(" ");
    }

    Task getValidTask() {
        return new Task(1, "Test", "Testtestest", new GregorianCalendar(1980, Calendar.SEPTEMBER, 19).getTime(), TaskStatus.DONE, 2);
    }

    String[] getNotEnoughArgs() {
        return "Test testtest 19.09.1980".split(" ");
    }

}
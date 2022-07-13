package shagiev.homework2.services.console.commands;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;
import shagiev.homework2.services.console.managers.TaskManager;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShowTaskCommandTest {

    TaskManager taskManagerMock = Mockito.mock(TaskManager.class);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    Writer writer = new OutputStreamWriter(byteArrayOutputStream);
    ShowTaskCommand command = new ShowTaskCommand(taskManagerMock, writer);

    {
        Mockito.when(taskManagerMock.getTasks(getValidId())).thenReturn(getTasks());
    }

    @Test
    void execute_notEnoughArguments_throwsException() {
        assertThrows(NotEnoughArgumentsException.class, () -> command.execute(getNotEnoughArgs()));
    }

    @Test
    void execute_invalidArguments_throwsException() {
        assertThrows(NumberFormatException.class, () -> command.execute(getInvalidArgs()));
    }

    @Test
    void execute_validArguments_validBehaviour() {
        boolean result = command.execute(getValidArgs());
        String message = byteArrayOutputStream.toString();
        assertEquals(getValidMessage(), message);
        assertFalse(result);
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
        return "test test".split(" ");
    }

    List<Task> getTasks() {
        List<Task> list = new ArrayList<>();
        list.add(new Task(1, "Test1", "Testtesttest", new Date(1999999999), TaskStatus.NEW, 1));
        list.add(new Task(2, "Test2", "Testtesttest", new Date(999999999), TaskStatus.IN_PROGRESS, 1));
        list.add(new Task(6, "Test6", "Testtesttest", new Date(1889999999), TaskStatus.DONE, 1));
        list.add(new Task(9, "Test9", "Testtesttest", new Date(1997779991), TaskStatus.NEW, 1));
        list.add(new Task(100, "Test100", "Testtesttest", new Date(1222922299), TaskStatus.IN_PROGRESS, 1));
        return list;
    }

    String getValidMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Task task: getTasks()) {
            stringBuilder.append(task.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
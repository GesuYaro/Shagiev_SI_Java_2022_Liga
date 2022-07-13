package shagiev.homework2.services.console.managers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shagiev.homework2.model.task.TaskStatus;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryImplTest {

    TaskFactoryImpl taskFactory = new TaskFactoryImpl();

    @Test
    void getDate_validString_validDate() {
        Date result = taskFactory.getDate(getValidDateString());
        Assertions.assertEquals(getValidDate(), result);
    }

    @Test
    void getDate_invalidString_null() {
        Date result = taskFactory.getDate(getInvalidDateString());
        Assertions.assertNull(result);
    }

    @Test
    void getTaskStatus_validString_validTaskStatus() {
        TaskStatus result = taskFactory.getTaskStatus(getValidTaskStatusString());
        Assertions.assertEquals(getValidTaskStatus(), result);
    }

    @Test
    void getTaskStatus_invalidString_null() {
        TaskStatus result = taskFactory.getTaskStatus(getInvalidTaskStatusString());
        assertNull(result);
    }

    @Test
    void getUserId_validString_validId() {
        int result = taskFactory.getUserId(getValidIdString());
        Assertions.assertEquals(getValidId(), result);
    }

    @Test
    void getUserId_invalidString_null() {
        Integer result = taskFactory.getUserId(getInvalidIdString());
        assertNull(result);
    }

    String getValidDateString() {
        return "31.01.2002";
    }

    Date getValidDate() {
        return new GregorianCalendar(2002, Calendar.JANUARY, 31).getTime();
    }

    String getInvalidDateString() {
        return "test";
    }

    String getValidIdString() {
        return "123";
    }

    String getInvalidIdString() {
        return "1test1";
    }

    int getValidId() {
        return 123;
    }

    String getValidTaskStatusString() {
        return "done";
    }

    String getInvalidTaskStatusString() {
        return "test_test";
    }

    TaskStatus getValidTaskStatus() {
        return TaskStatus.DONE;
    }

}
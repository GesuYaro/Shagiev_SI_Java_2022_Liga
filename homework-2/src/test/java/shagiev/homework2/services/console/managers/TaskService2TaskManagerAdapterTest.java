package shagiev.homework2.services.console.managers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shagiev.homework2.dto.task.TaskRequestDto;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;
import shagiev.homework2.model.user.User;
import shagiev.homework2.services.task.TaskService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class TaskService2TaskManagerAdapterTest {

    TaskService taskServiceMock = Mockito.mock(TaskService.class);
    TaskService2TaskManagerAdapter taskManagerAdapter = new TaskService2TaskManagerAdapter(taskServiceMock);

    {
        Mockito.when(taskServiceMock.getTasksByUserId(1)).thenReturn(getTasksByUserId1List());
        Mockito.when(taskServiceMock.getAllTasks()).thenReturn(getTasksList());
        Mockito.when(taskServiceMock.getTasksByUserIdAndStatus(1, TaskStatus.NEW)).thenReturn(getTasksByStatusNEWList());
    }


    @Test
    void getTasks_validList_validList() {
        Assertions.assertEquals(getTasksByUserId1List(), taskManagerAdapter.getTasks(1));
    }

    @Test
    void getAllTasks_validList_validList() {
        Assertions.assertEquals(getTasksList(), taskManagerAdapter.getAllTasks());
    }

    @Test
    void getTasksByStatus() {
        Assertions.assertEquals(getTasksByStatusNEWList(), taskManagerAdapter.getTasksByStatus(1, TaskStatus.NEW));
    }

    @Test
    void addTaskTest() {
        taskManagerAdapter.addTask(getValidTaskDTO());
        Mockito.verify(taskServiceMock).save(getValidTaskDTO());
    }

    @Test
    void clearTest() {
        taskManagerAdapter.clear(4);
        Mockito.verify(taskServiceMock).deleteByUserId(4);
    }

    @Test
    void clearAllTest() {
        taskManagerAdapter.clearAll();
        Mockito.verify(taskServiceMock).clear();
    }

    @Test
    void deleteTest() {
        taskManagerAdapter.delete(2);
        Mockito.verify(taskServiceMock).deleteById(2);
    }

    @Test
    void updateTaskTest() {
        TaskRequestDto task = getValidTaskDTO();
        taskManagerAdapter.updateTask(2, task);
        Mockito.verify(taskServiceMock).updateTask(2, task.getHeader(),
                task.getDescription(), task.getDate(), task.getStatus(), task.getUserId());
    }

    @Test
    void updateStatusTest() {
        taskManagerAdapter.updateStatus(2, TaskStatus.DONE);
        Mockito.verify(taskServiceMock).updateStatus(2, TaskStatus.DONE);
    }

    List<Task> getTasksList() {
        List<Task> taskList = new ArrayList<>();
        User user = new User(1, "Petya",null);
        User anotherUser = new User(2, "Vasya", null);
        taskList.add(new Task(1, "Test1", "test test", new Date(1000000000L), TaskStatus.NEW, user));
        taskList.add(new Task(2, "Test2", "test test", new Date(2000000000L), TaskStatus.DONE, user));
        taskList.add(new Task(3, "Test3", "test test", new Date(3000000000L), TaskStatus.IN_PROGRESS, user));
        taskList.add(new Task(10, "Test4", "test test", new Date(4000000000L), TaskStatus.NEW, user));
        taskList.add(new Task(999, "Test5", "test test", new Date(5000000000L), TaskStatus.IN_PROGRESS, user));
        taskList.add(new Task(90, "Test5", "test test", new Date(5000000000L), TaskStatus.IN_PROGRESS, anotherUser));
        taskList.add(new Task(99, "Test5", "test test", new Date(5000000000L), TaskStatus.IN_PROGRESS, anotherUser));

        return taskList;
    }

    List<Task> getTasksByUserId1List() {
        List<Task> taskList = new ArrayList<>();
        User user = new User(1, "Petya",null);
        taskList.add(new Task(1, "Test1", "test test", new Date(1000000000L), TaskStatus.NEW, user));
        taskList.add(new Task(2, "Test2", "test test", new Date(2000000000L), TaskStatus.DONE, user));
        taskList.add(new Task(3, "Test3", "test test", new Date(3000000000L), TaskStatus.IN_PROGRESS, user));
        taskList.add(new Task(10, "Test4", "test test", new Date(4000000000L), TaskStatus.NEW, user));
        taskList.add(new Task(999, "Test5", "test test", new Date(5000000000L), TaskStatus.IN_PROGRESS, user));
        return taskList;
    }

    List<Task> getTasksByStatusNEWList() {
        List<Task> taskList = new ArrayList<>();
        User user = new User(1, "Petya",null);
        taskList.add(new Task(1, "Test1", "test test", new Date(1000000000L), TaskStatus.NEW, user));
        taskList.add(new Task(10, "Test4", "test test", new Date(4000000000L), TaskStatus.NEW, user));
        return taskList;
    }

    TaskRequestDto getValidTaskDTO() {
        return new TaskRequestDto(1000, "Test1000", "test test", new Date(1000000000L), TaskStatus.NEW, 90);
    }

}
package task.manager;

import task.Task;
import task.TaskStatus;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class HeapTaskManager implements TaskManager {

    private int biggestId;
    private final List<Task> tasksList;

    public HeapTaskManager(List<Task> tasksList) {
        this.tasksList = tasksList;
        if (!tasksList.isEmpty()) {
            biggestId = findBiggestId(tasksList);
        } else {
            biggestId = 0;
        }
    }

    private static int findBiggestId(List<Task> tasksList) {
        return tasksList.stream()
                .max((task1, task2) -> Integer.compare(task1.getId(), task2.getId()))
                .orElseThrow()
                .getId();
    }

    @Override
    public List<Task> getTasks(int userId) {
        return tasksList.stream()
                .filter(task -> task.getUserId() == userId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> getTasksByStatus(int userId, TaskStatus status) {
        return tasksList.stream()
                .filter(task -> task.getUserId() == userId && task.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> getTasksOrderedByDate(int userId) {
        return tasksList.stream()
                .filter(task -> task.getUserId() == userId)
                .sorted((task1, task2) -> task1.getDate().compareTo(task2.getDate()))
                .collect(Collectors.toList());
    }

    @Override
    public void addTask(Task task) {
        int newId = ++biggestId;
        task.setId(newId);
        tasksList.add(task);
    }

    @Override
    public void clear(int userId) {
        tasksList.removeIf(task -> task.getUserId() == userId);
    }

    @Override
    public void delete(int id) {
        tasksList.removeIf(task -> task.getId() == id);
    }

    @Override
    public void updateTask(int id, Task task) {
        task.setId(id);
        for (ListIterator<Task> it = tasksList.listIterator(); it.hasNext(); ) {
            if (it.next().getId() == id) {
                it.set(task);
            }
        }
    }

    @Override
    public void updateStatus(int id, TaskStatus status) {
        for (ListIterator<Task> it = tasksList.listIterator(); it.hasNext(); ) {
            Task current = it.next();
            if (current.getId() == id) {
                current.setStatus(status);
            }
        }
    }

    @Override
    public void clearAll() {
        tasksList.clear();
    }

}

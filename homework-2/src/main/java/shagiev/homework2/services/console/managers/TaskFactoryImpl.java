package shagiev.homework2.services.console.managers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class TaskFactoryImpl implements TaskFactory {

    public Task getTask(String id, String header, String description,
                       String date, String status, String userId) {
        return new Task(0, header, description, getDate(date), getTaskStatus(status), getUserId(userId));
    }

    public Date getDate(String string) {
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            date = dateFormat.parse(string);
        } catch (ParseException e) {
            log.error("Can't parse date\n");
        }
        return date;
    }

    @Override
    public TaskStatus getTaskStatus(String string) {
        TaskStatus status = null;
        if (string != null) {
            string = string.trim().toUpperCase();
        }
        try {
            status = TaskStatus.valueOf(string);
        } catch (IllegalArgumentException e) {
            log.error("Can't parse status\n");
        }
        return status;
    }

    public int getUserId(String string) {
        Integer id = null;
        try {
            id = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            log.error("Can't parse id\n");
        }
        return id;
    }

}

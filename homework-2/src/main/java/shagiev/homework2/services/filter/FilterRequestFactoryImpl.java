package shagiev.homework2.services.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shagiev.homework2.model.task.TaskStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class FilterRequestFactoryImpl implements FilterRequestFactory {

    @Override
    public FilterRequest create(String taskStatusString, String fromString, String untilString) {
        Date from = null;
        Date until = null;
        TaskStatus taskStatus = null;
        if (fromString != null) {
            from = getDate(fromString);
        }
        if (untilString != null) {
            until = getDate(untilString);
        }
        if (taskStatusString != null) {
            taskStatus = getTaskStatus(taskStatusString);
        }
        return new FilterRequest(taskStatus, from, until);
    }

    private Date getDate(String string) {
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            date = dateFormat.parse(string);
        } catch (ParseException e) {
            log.error("Can't parse date\n");
        }
        return date;
    }

    private TaskStatus getTaskStatus(String string) {
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

}

package shagiev.homework2.services.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import shagiev.homework2.model.task.TaskStatus;

import java.util.Date;

@Data
@AllArgsConstructor
public class FilterRequest {

    private TaskStatus status;
    private Date from;
    private Date until;

}

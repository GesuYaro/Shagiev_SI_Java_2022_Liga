package shagiev.homework2.dto.task;


import lombok.AllArgsConstructor;
import lombok.Data;
import shagiev.homework2.model.task.TaskStatus;

import java.util.Date;

@Data
@AllArgsConstructor
public class TaskRequestDto {

    private String header;
    private String description;
    private Date date;
    private TaskStatus status;
    private int userId;

}

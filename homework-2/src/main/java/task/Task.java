package task;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Task {

    private int id;
    private String header;
    private String description;
    private Date date;
    private TaskStatus status;
    private int userId;

}

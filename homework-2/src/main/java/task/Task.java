package task;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @CsvBindByName(column = "id", required = true)
    private int id;

    @CsvBindByName(column = "header", required = true)
    private String header;

    @CsvBindByName(column = "description", required = true)
    private String description;

    @CsvDate(value = "dd.MM.yyyy")
    @CsvBindByName(column = "date", required = true)
    private Date date;

    @CsvBindByName(column = "status")
    private TaskStatus status;

    @CsvBindByName(column = "userId", required = true)
    private int userId;

}

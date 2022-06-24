package user;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Getter
    @Setter
    @CsvBindByName(column = "id", required = true)
    private int id;
    @Getter
    @Setter
    @CsvBindByName(column = "name", required = true)
    private String name;

}

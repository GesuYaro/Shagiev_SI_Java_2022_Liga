package shagiev.homework2.model.task;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String header;
    private String description;
    private Date date;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private int userId;

}

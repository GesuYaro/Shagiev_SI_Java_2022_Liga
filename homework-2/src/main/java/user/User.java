package user;

import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String name;

}

package shagiev.homework2.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {

    private int id;
    private String name;
    private List<Integer> taskIds;

}
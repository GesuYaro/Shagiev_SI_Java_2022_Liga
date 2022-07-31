package shagiev.homework2.services.user;

import shagiev.homework2.dto.task.TaskInfoDto;
import shagiev.homework2.dto.user.UserInfoDto;
import shagiev.homework2.dto.user.UserRequestDto;

import java.util.List;

public interface UserCrudService {

    List<UserInfoDto> getAll();
    UserInfoDto getConcrete(int id);
    UserInfoDto save(UserRequestDto userRequestDto);
    int update(int id, UserRequestDto userRequestDto);
    void delete(int id);

    List<TaskInfoDto> getUserTasks(int id);

}

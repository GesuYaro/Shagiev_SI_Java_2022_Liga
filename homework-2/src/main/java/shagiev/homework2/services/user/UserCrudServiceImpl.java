package shagiev.homework2.services.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shagiev.homework2.dto.task.TaskInfoDto;
import shagiev.homework2.dto.user.UserInfoDto;
import shagiev.homework2.dto.user.UserRequestDto;
import shagiev.homework2.model.user.User;
import shagiev.homework2.services.task.TaskCrudService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCrudServiceImpl implements UserCrudService {

    private final UserService userService;
    private final TaskCrudService taskCrudService;
    private final UserDtoConverter userDtoConverter;

    @Override
    public List<UserInfoDto> getAll() {
        List<User> users = userService.getAll();
        return userDtoConverter.toUserInfoDtoList(users);
    }

    @Override
    public UserInfoDto getConcrete(int id) {
        User user = userService.getConcrete(id);
        if (user != null) {
            return userDtoConverter.toUserInfoDto(user);
        } else {
            return null;
        }
    }

    @Override
    public UserInfoDto save(UserRequestDto userRequestDto) {
        User user = userService.save(userRequestDto);
        return userDtoConverter.toUserInfoDto(user);
    }

    @Override
    public int update(int id, UserRequestDto userRequestDto) {
        return userService.updateName(id, userRequestDto.getName());
    }

    @Override
    public void delete(int id) {
        userService.deleteUser(id);
    }

    @Override
    public List<TaskInfoDto> getUserTasks(int id) {
        return taskCrudService.getByUserId(id);
    }

}

package shagiev.homework2.services.user;

import org.springframework.stereotype.Service;
import shagiev.homework2.dto.user.UserInfoDto;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.user.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDtoConverterImpl implements UserDtoConverter {

    @Override
    public List<UserInfoDto> toUserInfoDtoList(List<User> users) {
        List<UserInfoDto> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(toUserInfoDto(user));
        }
        return dtos;
    }

    @Override
    public UserInfoDto toUserInfoDto(User user) {
        List<Integer> taskIds = getTaskIds(user);
        return new UserInfoDto(user.getId(), user.getName(), taskIds);
    }

    private List<Integer> getTaskIds(User user) {
        if (user.getTasks() != null) {
            return user.getTasks().stream()
                    .map(Task::getId)
                    .toList();
        } else {
            return null;
        }
    }

}

package shagiev.homework2.services.user;

import org.springframework.stereotype.Service;
import shagiev.homework2.dto.user.UserInfoDTO;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.user.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDTOConverterImpl implements UserDTOConverter {

    @Override
    public List<UserInfoDTO> toUserInfoDTOList(List<User> users) {
        List<UserInfoDTO> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(toUserInfoDTO(user));
        }
        return dtos;
    }

    @Override
    public UserInfoDTO toUserInfoDTO(User user) {
        List<Integer> taskIds = getTaskIds(user);
        return new UserInfoDTO(user.getId(), user.getName(), taskIds);
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

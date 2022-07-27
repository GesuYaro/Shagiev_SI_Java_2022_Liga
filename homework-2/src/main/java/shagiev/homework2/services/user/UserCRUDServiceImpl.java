package shagiev.homework2.services.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shagiev.homework2.dto.user.UserInfoDTO;
import shagiev.homework2.model.user.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCRUDServiceImpl implements UserCRUDService {

    private final UserService userService;
    private final UserDTOConverter userDTOConverter;

    @Override
    public List<UserInfoDTO> getAll() {
        List<User> users = userService.getAll();
        return userDTOConverter.toUserInfoDTOList(users);
    }

}

package shagiev.homework2.services.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shagiev.homework2.dto.user.UserInfoDTO;
import shagiev.homework2.dto.user.UserRequestDTO;
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

    @Override
    public UserInfoDTO getConcrete(int id) {
        User user = userService.getConcrete(id);
        if (user != null) {
            return userDTOConverter.toUserInfoDTO(user);
        } else {
            return null;
        }
    }

    @Override
    public UserInfoDTO save(UserRequestDTO userRequestDTO) {
        User user = userService.save(userRequestDTO);
        return userDTOConverter.toUserInfoDTO(user);
    }

    @Override
    public int update(int id, UserRequestDTO userRequestDTO) {
        return userService.updateName(id, userRequestDTO.getName());
    }

    @Override
    public void delete(int id) {
        userService.deleteUser(id);
    }

}

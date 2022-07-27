package shagiev.homework2.services.user;

import shagiev.homework2.dto.user.UserInfoDTO;
import shagiev.homework2.model.user.User;

import java.util.List;

public interface UserDTOConverter {

    List<UserInfoDTO> toUserInfoDTOList(List<User> users);

}

package shagiev.homework2.services.user;

import shagiev.homework2.dto.user.UserInfoDto;
import shagiev.homework2.model.user.User;

import java.util.List;

public interface UserDtoConverter {

    List<UserInfoDto> toUserInfoDtoList(List<User> users);
    UserInfoDto toUserInfoDto(User user);

}

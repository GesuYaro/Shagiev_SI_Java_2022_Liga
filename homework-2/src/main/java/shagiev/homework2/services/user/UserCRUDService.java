package shagiev.homework2.services.user;

import shagiev.homework2.dto.user.UserInfoDTO;

import java.util.List;

public interface UserCRUDService {

    List<UserInfoDTO> getAll();

}

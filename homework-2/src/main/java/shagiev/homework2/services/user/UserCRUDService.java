package shagiev.homework2.services.user;

import shagiev.homework2.dto.user.UserInfoDTO;
import shagiev.homework2.dto.user.UserRequestDTO;

import java.util.List;

public interface UserCRUDService {

    List<UserInfoDTO> getAll();
    UserInfoDTO getConcrete(int id);
    UserInfoDTO save(UserRequestDTO userRequestDTO);
    int update(int id, UserRequestDTO userRequestDTO);
    void delete(int id);

}

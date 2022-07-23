package shagiev.homework2.services.console.managers;

import shagiev.homework2.dto.user.UserRequestDTO;

public interface UserFactory {

    UserRequestDTO getUser(String name);

}

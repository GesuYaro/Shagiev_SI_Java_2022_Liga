package shagiev.homework2.services.console.managers;

import shagiev.homework2.dto.user.UserRequestDto;

public interface UserFactory {

    UserRequestDto getUser(String name);

}

package shagiev.homework2.services.console.managers;

import org.springframework.stereotype.Service;
import shagiev.homework2.dto.user.UserRequestDto;

@Service
public class UserFactoryImpl implements UserFactory {

    @Override
    public UserRequestDto getUser(String name) {
        return new UserRequestDto(name);
    }

}

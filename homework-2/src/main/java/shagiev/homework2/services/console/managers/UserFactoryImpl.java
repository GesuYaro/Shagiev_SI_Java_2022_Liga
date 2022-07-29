package shagiev.homework2.services.console.managers;

import org.springframework.stereotype.Service;
import shagiev.homework2.dto.user.UserRequestDTO;
import shagiev.homework2.model.user.User;

@Service
public class UserFactoryImpl implements UserFactory {

    @Override
    public UserRequestDTO getUser(String name) {
        return new UserRequestDTO(name);
    }

}

package shagiev.homework2.services.console.managers;

import org.springframework.stereotype.Service;
import shagiev.homework2.model.user.User;

@Service
public class UserFactoryImpl implements UserFactory {

    @Override
    public User getUser(String name) {
        return new User(0, name);
    }

}

package shagiev.homework2.services.console.managers;

import org.junit.jupiter.api.Test;
import shagiev.homework2.model.user.User;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryImplTest {

    UserFactoryImpl userFactory = new UserFactoryImpl();

    @Test
    void getUserTest_validString_validUser() {
        assertEquals(getValidUser(), userFactory.getUser(getValidName()));
    }

    User getValidUser() {
        return new User(0, "Johny Test");
    }

    String getValidName() {
        return "Johny Test";
    }
}
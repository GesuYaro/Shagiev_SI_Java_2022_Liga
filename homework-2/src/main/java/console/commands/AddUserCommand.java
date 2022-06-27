package console.commands;

import lombok.RequiredArgsConstructor;
import user.UserBuilder;
import user.manager.UserManager;

import java.io.IOException;

@RequiredArgsConstructor
public class AddUserCommand implements Command {

    private final String description = "add new user";
    private final UserBuilder userBuilder;
    private final UserManager userManager;

    @Override
    public boolean invoke(String[] args) {
        try {
            userManager.addUser(userBuilder.getUser());
        } catch (IOException e) {
            System.err.println("Problem with reading");
        }
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }

}

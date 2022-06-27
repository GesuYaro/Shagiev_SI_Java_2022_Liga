package console.commands;

import lombok.RequiredArgsConstructor;
import user.UserBuilder;
import user.manager.UserManager;

import java.io.IOException;

@RequiredArgsConstructor
public class UpdateUserCommand implements Command {

    private final String description = "{id} update user info";
    private final UserManager userManager;
    private final UserBuilder userBuilder;

    @Override
    public boolean invoke(String[] args) {
        if (args == null || args.length < 1) {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        try {
            userManager.updateUser(id, userBuilder.getUser());
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

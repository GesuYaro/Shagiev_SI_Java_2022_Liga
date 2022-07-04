package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.services.console.managers.UserFactory;
import shagiev.homework2.services.console.managers.UserManager;

@RequiredArgsConstructor
@Component
public class AddUserCommand implements Command {

    private final String description = "add new user";
    private final UserFactory userFactory;
    private final UserManager userManager;

    @Override
    public boolean execute(String[] args) {
        if (args == null || args.length < 1) {
            throw new NotEnoughArgumentsException();
        }
        userManager.addUser(userFactory.getUser(args[0]));
        return false;
    }

    @Override
    public String getName() {
        return "add_user";
    }

    @Override
    public String getDescription() {
        return description;
    }

}

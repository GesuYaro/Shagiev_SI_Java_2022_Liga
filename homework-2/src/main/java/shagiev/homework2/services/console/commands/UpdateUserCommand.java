package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.services.console.managers.UserFactory;
import shagiev.homework2.services.console.managers.UserManager;

@RequiredArgsConstructor
@Component
public class UpdateUserCommand implements Command {

    private final String description = "{id} update user info";
    private final UserManager userManager;
    private final UserFactory userFactory;

    @Override
    public boolean execute(String[] args) {
        if (args == null || args.length < 2) {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        userManager.updateUser(id, userFactory.getUser(args[1]));
        return false;
    }

    @Override
    public String getName() {
        return "update_user";
    }

    @Override
    public String getDescription() {
        return description;
    }

}

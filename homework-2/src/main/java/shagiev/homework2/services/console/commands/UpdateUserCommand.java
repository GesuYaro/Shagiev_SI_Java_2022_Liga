package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.services.console.managers.UserFactory;
import shagiev.homework2.services.console.managers.UserManager;

@RequiredArgsConstructor
@Component
public class UpdateUserCommand implements Command {

    private final UserManager userManager;
    private final UserFactory userFactory;

    @Override
    public boolean execute(String[] args) {
        if (args == null || args.length < 2) {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        String username = args[1];
        userManager.updateUser(id, userFactory.getUser(username));
        return false;
    }

    @Override
    public CommandName getName() {
        return CommandName.UPDATE_USER;
    }

    @Override
    public String getDescription() {
        return "{id} update user info";
    }

}

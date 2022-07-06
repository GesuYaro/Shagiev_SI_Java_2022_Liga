package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.services.console.managers.UserManager;

@RequiredArgsConstructor
@Component
public class DeleteUserCommand implements Command {

    private final UserManager userManager;

    @Override
    public boolean execute(String[] args) {
        if (args == null || args.length < 1)  {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        userManager.deleteUser(id);
        return false;
    }

    @Override
    public CommandName getName() {
        return CommandName.DELETE_USER;
    }

    @Override
    public String getDescription() {
        return "{id} delete user";
    }

}

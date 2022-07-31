package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.dto.command.CommandResponseDto;
import shagiev.homework2.services.console.managers.UserFactory;
import shagiev.homework2.services.console.managers.UserManager;

@RequiredArgsConstructor
@Component
public class AddUserCommand implements Command {

    private final UserFactory userFactory;
    private final UserManager userManager;

    @Override
    public CommandResponseDto execute(String[] args) {
        if (args == null || args.length < 1) {
            throw new NotEnoughArgumentsException();
        }
        String username = args[0];
        userManager.addUser(userFactory.getUser(username));
        return new CommandResponseDto("ok");
    }

    @Override
    public CommandName getName() {
        return CommandName.ADD_USER;
    }

    @Override
    public String getDescription() {
        return "add new user";
    }

}

package console.commands;

import lombok.RequiredArgsConstructor;
import user.manager.UserManager;

@RequiredArgsConstructor
public class DeleteUserCommand implements Command {

    private final String description = "{id} delete user";
    private final UserManager userManager;

    @Override
    public boolean invoke(String[] args) {
        if (args == null || args.length < 1)  {
            throw new NotEnoughArgumentsException();
        }
        int id = Integer.parseInt(args[0]);
        userManager.deleteUser(id);
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }

}

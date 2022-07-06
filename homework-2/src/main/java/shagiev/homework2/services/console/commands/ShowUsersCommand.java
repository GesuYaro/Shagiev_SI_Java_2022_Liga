package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.model.user.User;
import shagiev.homework2.services.console.managers.UserManager;

import java.io.IOException;
import java.io.Writer;

@RequiredArgsConstructor
@Component
public class ShowUsersCommand implements Command {

    private final UserManager userManager;
    private final Writer writer;

    @Override
    public boolean execute(String[] args) {
        try {
            for (User user : userManager.getUsers()) {
                writer.write(user.toString());
                writer.write("\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.err.println("Problem with printing");
        }
        return false;
    }

    @Override
    public CommandName getName() {
        return CommandName.SHOW_USERS;
    }

    @Override
    public String getDescription() {
        return "show users info";
    }

}

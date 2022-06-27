package console.commands;

import lombok.RequiredArgsConstructor;
import user.User;
import user.manager.UserManager;

import java.io.IOException;
import java.io.Writer;

@RequiredArgsConstructor
public class ShowUsersCommand implements Command {

    private final String description = "show users info";
    private final UserManager userManager;
    private final Writer writer;

    @Override
    public boolean invoke(String[] args) {
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
    public String getDescription() {
        return description;
    }

}

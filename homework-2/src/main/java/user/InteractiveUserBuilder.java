package user;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

@RequiredArgsConstructor
public class InteractiveUserBuilder implements UserBuilder {

    private final Scanner scanner;
    private final Writer writer;

    @Override
    public User getUser() throws IOException {
        return new User(0, getName());
    }

    public String getName() throws IOException {
        String name = null;
        do {
            writer.write("Enter name:");
            writer.flush();
            name = scanner.nextLine();
        } while (name == null || name.trim().length() < 1);
        return name;
    }

}

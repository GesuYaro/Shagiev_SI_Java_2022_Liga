package console.commands;

public class ExitCommand implements Command {

    private final String description = "Exit program (without saving)";

    @Override
    public boolean invoke(String[] args) {
        return true;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

package console.commands;

public interface Command {

    boolean invoke(String[] args);
    String getDescription();

}

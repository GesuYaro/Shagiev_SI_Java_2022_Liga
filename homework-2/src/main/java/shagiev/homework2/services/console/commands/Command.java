package shagiev.homework2.services.console.commands;

public interface Command {

    boolean execute(String[] args);
    CommandName getName();
    String getDescription();

}

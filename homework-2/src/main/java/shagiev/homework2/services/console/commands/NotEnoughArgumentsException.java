package shagiev.homework2.services.console.commands;

public class NotEnoughArgumentsException extends RuntimeException {

    public NotEnoughArgumentsException(String message) {
        super(message);
    }

    public NotEnoughArgumentsException() {
        super("Not enough arguments");
    }
}

package shagiev.homework2.services.console.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExitCommandTest {

    ExitCommand command = new ExitCommand();

    @Test
    void execute_anyArguments_validBehaviour() {
        boolean result = command.execute(getAnyArgument());
        assertTrue(result);
    }

    String[] getAnyArgument() {
        return "test 1".split(" ");
    }
}
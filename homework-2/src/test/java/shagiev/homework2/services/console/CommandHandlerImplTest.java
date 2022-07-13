package shagiev.homework2.services.console;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shagiev.homework2.services.console.commands.AddTaskCommand;
import shagiev.homework2.services.console.commands.Command;
import shagiev.homework2.services.console.commands.CommandName;
import shagiev.homework2.services.console.commands.NotEnoughArgumentsException;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandHandlerImplTest {

    List<Command> commandList;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    CommandHandlerImpl commandHandler;
    Command clearCommandMock = Mockito.mock(Command.class);
    Command addTaskCommandMock = Mockito.mock(Command.class);

    {
        Mockito.when(addTaskCommandMock.getName()).thenReturn(CommandName.ADD_TASK);
        Mockito.when(addTaskCommandMock.execute(getValidCommandArgs())).thenReturn(false);
        Mockito.when(addTaskCommandMock.execute(getNotEnoughArguments())).thenThrow(new NotEnoughArgumentsException());
        Mockito.when(clearCommandMock.getName()).thenReturn(CommandName.CLEAR);
        commandList = new ArrayList<>();
        commandList.add(addTaskCommandMock);
        commandList.add(clearCommandMock);
        commandHandler = new CommandHandlerImpl(commandList, byteArrayOutputStream);
    }

    @Test
    void handleCommand_validCommandName_validBehaviour() {
        commandHandler.handleCommand(getValidCommand());
        Mockito.verify(addTaskCommandMock).execute(getValidCommandArgs());
    }

    @Test
    void handleCommand_validCommandName_notEnoughArguments() {
        String result = commandHandler.handleCommand(getCommandNotEnoughArguments());
        Assertions.assertEquals(getNotEnoughResult(), result);
    }

    @Test
    void handleCommand_invalidCommandName() {
        String result = commandHandler.handleCommand(getInvalidCommand());
        Assertions.assertEquals(getInvalidCommandResult(), result);
    }

    @Test
    void handleCommand_notImplementedCommand() {
        String result = commandHandler.handleCommand(getNotImplementedCommand());
        Assertions.assertEquals(getNotImplementedResult(), result);
    }

    String getValidCommand() {
        return "add_task test testtesttest 19.07.2021 done 2";
    }

    String[] getValidCommandArgs() {
        return "test testtesttest 19.07.2021 done 2".split(" ");
    }

    String getInvalidCommand() {
        return "test_command test testtesttest 19.07.2021 done 2";
    }

    String getCommandNotEnoughArguments() {
        return "add_task test testtesttest 19.07.2021";
    }

    String[] getNotEnoughArguments() {
        return "test testtesttest 19.07.2021".split(" ");
    }

    String getNotImplementedCommand() {
        return "update_task 1 test testtesttest 19.07.2021 done 2";
    }

    String getNotEnoughResult() {
        return "Argument error. Not enough arguments\n";
    }

    String getInvalidCommandResult() {
        return "Command test_command not found\n";
    }

    String getNotImplementedResult() {
        return "Command update_task not implemented\n";
    }
}
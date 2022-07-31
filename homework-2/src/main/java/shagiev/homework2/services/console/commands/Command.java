package shagiev.homework2.services.console.commands;

import shagiev.homework2.dto.command.CommandResponseDto;

public interface Command {

    CommandResponseDto execute(String[] args);
    CommandName getName();
    String getDescription();

}

package shagiev.homework2.services.console.commands;

import shagiev.homework2.dto.command.CommandResponseDTO;

public interface Command {

    CommandResponseDTO execute(String[] args);
    CommandName getName();
    String getDescription();

}

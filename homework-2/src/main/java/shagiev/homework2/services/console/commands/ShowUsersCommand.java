package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.dto.command.CommandResponseDTO;
import shagiev.homework2.dto.user.UserInfoDTO;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.user.User;
import shagiev.homework2.services.console.managers.UserManager;

import java.io.Writer;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ShowUsersCommand implements Command {

    private final UserManager userManager;

    @Override
    public CommandResponseDTO execute(String[] args) {
        CommandResponseDTO response = new CommandResponseDTO();
        for (User user : userManager.getUsers()) {
            List<Integer> taskIds = user.getTasks().stream()
                    .map(Task::getId)
                    .toList();
            response.addUser(new UserInfoDTO(
                    user.getId(),
                    user.getName(),
                    taskIds
            ));
        }
        return response;
    }

    @Override
    public CommandName getName() {
        return CommandName.SHOW_USERS;
    }

    @Override
    public String getDescription() {
        return "show users info";
    }

}

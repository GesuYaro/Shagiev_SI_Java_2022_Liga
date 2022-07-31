package shagiev.homework2.services.console.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shagiev.homework2.dto.command.CommandResponseDto;
import shagiev.homework2.dto.user.UserInfoDto;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.user.User;
import shagiev.homework2.services.console.managers.UserManager;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ShowUsersCommand implements Command {

    private final UserManager userManager;

    @Override
    public CommandResponseDto execute(String[] args) {
        CommandResponseDto response = new CommandResponseDto();
        for (User user : userManager.getUsers()) {
            List<Integer> taskIds = user.getTasks().stream()
                    .map(Task::getId)
                    .toList();
            response.addUser(new UserInfoDto(
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

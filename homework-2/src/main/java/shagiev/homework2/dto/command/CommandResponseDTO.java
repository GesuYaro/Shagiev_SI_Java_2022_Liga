package shagiev.homework2.dto.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shagiev.homework2.dto.task.TaskInfoDTO;
import shagiev.homework2.dto.user.UserInfoDTO;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandResponseDTO {

    private String message;
    private List<UserInfoDTO> users;
    private List<TaskInfoDTO> tasks;

    public CommandResponseDTO(String message) {
        this.message = message;
    }

    public void addTask(TaskInfoDTO task) {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(task);
    }

    public void addUser(UserInfoDTO user) {
        if (users == null) {
            users = new ArrayList<>();
        }
        users.add(user);
    }

}

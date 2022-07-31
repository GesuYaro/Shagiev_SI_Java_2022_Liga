package shagiev.homework2.dto.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shagiev.homework2.dto.task.TaskInfoDto;
import shagiev.homework2.dto.user.UserInfoDto;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandResponseDto {

    private String message;
    private List<UserInfoDto> users;
    private List<TaskInfoDto> tasks;

    public CommandResponseDto(String message) {
        this.message = message;
    }

    public void addTask(TaskInfoDto task) {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(task);
    }

    public void addUser(UserInfoDto user) {
        if (users == null) {
            users = new ArrayList<>();
        }
        users.add(user);
    }

}

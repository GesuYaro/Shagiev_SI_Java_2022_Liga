package app;

import console.Console;
import console.commands.*;
import file.parser.CSVParser;
import file.writer.CSVFilePrinter;
import task.InteractiveTaskBuilder;
import task.Task;
import task.manager.HeapTaskManager;
import task.manager.TaskManager;
import user.InteractiveUserBuilder;
import user.User;
import user.UserBuilder;
import user.manager.HeapUserManager;
import user.manager.UserManager;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            List<User> users = CSVParser.parse(args[0], User.class);
            List<Task> tasks = CSVParser.parse(args[1], Task.class);
            UserManager userManager = new HeapUserManager(users);
            TaskManager taskManager = new HeapTaskManager(tasks);
            Scanner consoleScanner = new Scanner(System.in);
            Writer writer = new BufferedWriter(new OutputStreamWriter(System.out));
            UserBuilder userBuilder = new InteractiveUserBuilder(consoleScanner, writer);
            InteractiveTaskBuilder taskBuilder = new InteractiveTaskBuilder(consoleScanner, writer);
            Map<String, Command> commandMap = new HashMap<>();
            commandMap.put("help", new HelpCommand(writer, commandMap));
            commandMap.put("exit", new ExitCommand());
            commandMap.put("show_users", new ShowUsersCommand(userManager, writer));
            commandMap.put("show_tasks", new ShowTaskCommand(taskManager, writer));
            commandMap.put("add_user", new AddUserCommand(userBuilder, userManager));
            commandMap.put("add_task", new AddTaskCommand(taskBuilder, taskManager));
            commandMap.put("delete_user", new DeleteUserCommand(userManager));
            commandMap.put("delete_task", new DeleteTaskCommand(taskManager));
            commandMap.put("update_user", new UpdateUserCommand(userManager, userBuilder));
            commandMap.put("update_task", new UpdateTaskCommand(taskManager, taskBuilder));
            commandMap.put("filter_by_status", new FilterByStatusCommand(taskBuilder, taskManager, writer));
            commandMap.put("change_status", new ChangeStatusCommand(taskManager, taskBuilder));
            commandMap.put("clear", new ClearCommand(taskManager, userManager));
            commandMap.put("save", new SaveCommand(new CSVFilePrinter(new File(args[1])), new CSVFilePrinter(new File(args[0])), taskManager, userManager));
            Console console = new Console(commandMap,
                    consoleScanner,
                    writer);
            console.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

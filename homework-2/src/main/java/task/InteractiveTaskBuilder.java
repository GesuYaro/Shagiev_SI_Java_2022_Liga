package task;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@RequiredArgsConstructor
public class InteractiveTaskBuilder implements TaskBuilder {

    private final Scanner scanner;
    private final Writer writer;

    @Override
    public Task getTask() throws IOException {
        return new Task(0, getString("Enter header:"), getString("Enter description:"), getDate(), getTaskStatus(), getUserId());
    }

    public String getString(String message) throws IOException {
        String string = null;
        do {
            writer.write(message);
            writer.flush();
            string = scanner.nextLine();
        } while (string == null || string.trim().length() < 1);
        return string;
    }

    public Date getDate() throws IOException {
        Date date = null;
        do {
            writer.write("Enter date in dd.MM.yyyy format:");
            writer.flush();
            String string = scanner.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            try {
                date = dateFormat.parse(string);
            } catch (ParseException e) {
                writer.write("Can't parse date\n");
                writer.flush();
            }
        } while (date == null);
        return date;
    }

    public TaskStatus getTaskStatus() throws IOException {
        TaskStatus status = null;
        do {
            writer.write("Choose task status from:\n");
            for (TaskStatus taskStatus: TaskStatus.values()) {
                writer.write(taskStatus.name());
                writer.write("\n");
            }
            writer.flush();
            String string = scanner.nextLine();
            if (string != null) {
                string = string.trim().toUpperCase();
            }
            try {
                status = TaskStatus.valueOf(string);
            } catch (IllegalArgumentException e) {
                writer.write("Can't parse status\n");
                writer.flush();
            }
        } while (status == null);
        return status;
    }

    public int getUserId() throws IOException {
        Integer id = null;
        do {
            writer.write("Enter user id:");
            writer.flush();
            String string = scanner.nextLine();
            try {
                id = Integer.parseInt(string);
            } catch (NumberFormatException e) {
                writer.write("Can't parse id\n");
                writer.flush();
            }
        } while (id == null);
        return id;
    }

}

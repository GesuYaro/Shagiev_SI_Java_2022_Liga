package shagiev.homework2.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;
import shagiev.homework2.model.user.User;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

    List<Task> findAllByUserId(int userId);
    List<Task> findAllByUserIdAndStatus(int userId, TaskStatus status);
    void deleteAllByUserId(int userId);
    @Modifying
    @Query("update Task t set t.status = ?2 where t.id = ?1")
    void updateStatusById(int id, TaskStatus taskStatus);

    @Modifying
    @Query("update Task t set t.header = ?2, t.description = ?3, t.date = ?4, t.status = ?5, t.user = ?6 where t.id = ?1")
    void updateTaskById(int id, String header, String description, Date date, TaskStatus taskStatus, User user);

}

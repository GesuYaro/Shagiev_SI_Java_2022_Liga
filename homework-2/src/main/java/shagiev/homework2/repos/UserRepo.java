package shagiev.homework2.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shagiev.homework2.model.user.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Modifying
    @Query("update User u set u.name = ?2 where u.id = ?1")
    void updateNameById(int id, String name);

}

package shagiev.homework2.repos;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shagiev.homework2.model.user.User;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    @Override
    @EntityGraph(attributePaths = "tasks")
    @Transactional(readOnly = true)
    List<User> findAll();

    @Modifying
    @Query("update User u set u.name = ?2 where u.id = ?1")
    void updateNameById(int id, String name);

}

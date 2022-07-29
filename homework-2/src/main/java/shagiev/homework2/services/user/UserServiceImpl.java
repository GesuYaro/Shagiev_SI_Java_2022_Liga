package shagiev.homework2.services.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shagiev.homework2.dto.user.UserRequestDTO;
import shagiev.homework2.model.user.User;
import shagiev.homework2.repos.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User getConcrete(int id) {
        var user = userRepo.findById(id);
        return user.orElse(null);
    }

    @Transactional
    @Override
    public User save(UserRequestDTO user) {
        return userRepo.save(new User(0, user.getName(), null));
    }

    @Transactional
    @Override
    public int updateName(int id, String name) {
        return userRepo.updateNameById(id, name);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    @Transactional
    @Override
    public void clear() {
        userRepo.deleteAll();
    }
}

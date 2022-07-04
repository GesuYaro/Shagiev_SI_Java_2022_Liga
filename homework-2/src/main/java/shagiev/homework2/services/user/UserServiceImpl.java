package shagiev.homework2.services.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Transactional
    @Override
    public void updateName(int id, String name) {
        userRepo.updateNameById(id, name);
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

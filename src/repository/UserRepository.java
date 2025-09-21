package repository;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    List<User> findAll();
    Optional<User> findByEmail(String email);
    boolean emailExists(String email);
}

package repository.impliment;

import model.User;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {
    private final HashMap<String, User> users = new HashMap<>();

    @Override
    public User save(User user) {
        users.put(user.getEmail(), user);
        System.out.println(users);
        return user;
    }
    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
    @Override
    public Optional<User> findByEmail(String email) {
        return users.values().stream()
                .filter(u ->u.getEmail().equals(email))
                .findFirst();
    }

    public boolean emailExists(String email) {
        return findByEmail(email).isPresent();
    }


}

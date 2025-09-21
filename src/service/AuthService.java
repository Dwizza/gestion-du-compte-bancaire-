package service;

import model.User;
import repository.UserRepository;

import java.util.Optional;

public class AuthService
{
    private UserRepository userRepository ;
    private static User currentUser;


    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean register(String name, String email, String address, String password) {

        if(userRepository.emailExists(email)) {
            throw new RuntimeException("User with this email already exists!");
        }
        if(password.length() < 6) {
            throw new RuntimeException("Password too short!");
        }
        User user = new User(name,email,address,password);
        userRepository.save(user);
        return true;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    public boolean login(String email, String password) {

        if (email == null || password == null) {
            throw new RuntimeException("User not found!");
        }
        return userRepository.findByEmail(email.trim().toLowerCase())
                .filter(user -> user.getPassword().equals(password))
                .map(user -> {
                    this.currentUser = user;
                    return true;
                })
                .orElse(false);

    }

}

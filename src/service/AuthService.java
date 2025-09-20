package service;

import model.User;
import repository.UserRepository;

import java.util.Optional;

public class AuthService
{
    private UserRepository userRepository ;
    private User currentUser;
//    private User user;

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
    public boolean login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        if (!user.get().getPassword().equals(password)) {
            throw new RuntimeException("Invalid password!");
        }

//        return userRepository.findByEmail(email).filter(user ->{
        return true;

    }

}

package no.ntnu.isaksj.backend.service;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import no.ntnu.isaksj.backend.model.User;
import no.ntnu.isaksj.backend.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User updateUser(@NotNull User user) {
        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } else {
            User oldUser = userRepository.findById(user.getId()).get();
            user.setPassword(oldUser.getPassword());
        }
        
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User setPasswordToNull(User user) {
        user.setPassword(null);
        return user;
    }
}

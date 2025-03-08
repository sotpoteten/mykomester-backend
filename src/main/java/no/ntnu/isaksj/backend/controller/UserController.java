package no.ntnu.isaksj.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import no.ntnu.isaksj.backend.model.User;
import no.ntnu.isaksj.backend.model.UserSettings;
import no.ntnu.isaksj.backend.service.UserService;
import no.ntnu.isaksj.backend.service.UserSettingsService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSettingsService userSettingsService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        if (userService.findByEmail(user.getEmail()) != null) {
            return new ResponseEntity<>("E-posten er allerede i bruk.", HttpStatus.CONFLICT);
        }

        User addedUser = userService.updateUser(user);

        UserSettings settings = new UserSettings();
        settings = userSettingsService.setStandardSettings(settings);
        settings.setUser(addedUser);
        userSettingsService.updateUserSettings(settings);

        userService.setPasswordToNull(addedUser);
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }    

    @PutMapping("/users/{email}")
    public ResponseEntity<Object> updateUser(@PathVariable String email, @RequestBody User user) {
        User oldUser = userService.findByEmail(email);

        if (oldUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        user.setId(oldUser.getId());
        user = userService.updateUser(user);
        userService.setPasswordToNull(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

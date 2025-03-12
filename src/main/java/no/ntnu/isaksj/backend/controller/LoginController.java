package no.ntnu.isaksj.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import no.ntnu.isaksj.backend.model.User;
import no.ntnu.isaksj.backend.service.LoginService;
import no.ntnu.isaksj.backend.service.MailSenderService;
import no.ntnu.isaksj.backend.service.UserService;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    UserService userService;

    @Autowired
    MailSenderService mailSenderService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        if (loginService.validateUser(user.getEmail(), user.getPassword())) {
            return new ResponseEntity<>(loginService.generateToken(user.getEmail()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("E-post eller passord er feil", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/check_token")
    public ResponseEntity<String> checkTokenValidity() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PostMapping("/glemt_passord")
    public ResponseEntity<String> forgotPassword(@RequestBody String email) {
        User u = userService.findByEmail(email);
        if (u != null) {
            String newPassword = loginService.generateNewPassword();
            u.setPassword(newPassword);
            userService.updateUser(u);
            mailSenderService.sendNewPasswordEmail(email, newPassword);
            return new ResponseEntity<>("New password sent to email " + email, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No user found with email " + email, HttpStatus.NOT_FOUND);
        }
    }
}

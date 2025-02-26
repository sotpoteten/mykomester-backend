package no.ntnu.isaksj.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import no.ntnu.isaksj.backend.model.User;
import no.ntnu.isaksj.backend.service.LoginService;
import no.ntnu.isaksj.backend.service.UserService;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    UserService userService;

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
}

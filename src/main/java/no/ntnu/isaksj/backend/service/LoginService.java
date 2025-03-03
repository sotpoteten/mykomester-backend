package no.ntnu.isaksj.backend.service;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import no.ntnu.isaksj.backend.model.User;

@Service
public class LoginService {
    public static final String KEY_STR = "jksadjdksankjcankjfujfpewkdsæadskamd3uiiewnekwfoidmfdøs391m";
    private static final Duration JWT_TOKEN_VALIDITY = Duration.ofMinutes(180);

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean validateUser(String email, String password) {
        User user = userService.findByEmail(email);
        
        if (user == null) return false;

        return passwordEncoder.matches(password, user.getPassword());
    }

    public String generateToken(final String email) {
        final Instant now = Instant.now();
        final Algorithm hmac512 = Algorithm.HMAC512(KEY_STR);
        return JWT.create()
            .withSubject(email)
            .withIssuer("mykomester_application")
            .withIssuedAt(now)
            .withExpiresAt(now.plusMillis(JWT_TOKEN_VALIDITY.toMillis()))
            .sign(hmac512);
    }
}

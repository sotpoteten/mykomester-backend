package no.ntnu.isaksj.backend.service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.Rule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
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

    /**
   * Method to generate a new random password.
   * Used when user has forgotten their original password.
   * Uses Passay password policy enforcement library.
   * Method is based on code from Baeldung: https://www.baeldung.com/java-generate-secure-password
   * Same method used in Systemutvikling 2 project spring 2024.
   */
    public String generateNewPassword() {
        PasswordGenerator gen = new PasswordGenerator();
        List<Rule> rules = new ArrayList<>();
                
        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(2);
        rules.add(lowerCaseRule);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(2);
        rules.add(upperCaseRule);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);
        rules.add(digitRule);

        CharacterData specialChars = new CharacterData() {
        public String getErrorCode() {
            return "ERROR_CODE"; // TODO Return suitable error-code
        }

        public String getCharacters() {
            return "!@#$%^&*()_+";
        }
        };

        CharacterRule specialCharacterRule = new CharacterRule(specialChars);
        specialCharacterRule.setNumberOfCharacters(2);
        rules.add(specialCharacterRule);

        return gen.generatePassword(12, rules);
    }
}

package no.ntnu.isaksj.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import no.ntnu.isaksj.backend.model.User;
import no.ntnu.isaksj.backend.model.UserSettings;
import no.ntnu.isaksj.backend.service.UserService;
import no.ntnu.isaksj.backend.service.UserSettingsService;

@RestController
public class UserSettingsController {
    @Autowired
    private UserSettingsService userSettingsService;

    @Autowired
    private UserService userService;

    @GetMapping("/usersettings/user/{email}")
    public ResponseEntity<UserSettings> getUserSettingsByUser(@PathVariable String email) {
        User user = userService.findByEmail(email);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        UserSettings userSettings = userSettingsService.findByUser(user);
        return new ResponseEntity<>(userSettings, HttpStatus.OK);
    }

    @PutMapping("usersettings/user/{email}")
    public ResponseEntity<UserSettings> updateUserSettings(@PathVariable String email, @RequestBody UserSettings userSettings) {
        User user = userService.findByEmail(email);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        UserSettings oldUserSettings = userSettingsService.findByUser(user);
        userSettings.setUser(user);
        userSettings.setId(oldUserSettings.getId());
        userSettings = userSettingsService.updateUserSettings(userSettings);
        return new ResponseEntity<UserSettings>(userSettings, HttpStatus.OK);
    }
}

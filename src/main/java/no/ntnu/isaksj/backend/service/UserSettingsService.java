package no.ntnu.isaksj.backend.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.ntnu.isaksj.backend.model.User;
import no.ntnu.isaksj.backend.model.UserSettings;
import no.ntnu.isaksj.backend.repository.UserSettingsRepository;

@Service
public class UserSettingsService {
    
    @Autowired
    private UserSettingsRepository userSettingsRepository;

    public UserSettings updateUserSettings(@NotNull UserSettings userSettings) {
        UserSettings updatedUserSettings = userSettingsRepository.save(userSettings);
        return updatedUserSettings;
    }

    public UserSettings findById(long id) {
        return userSettingsRepository.findById(id);
    }

    public UserSettings findByUser(User user) {
        return userSettingsRepository.findByUser(user);
    }
}

package no.ntnu.isaksj.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import no.ntnu.isaksj.backend.model.User;
import no.ntnu.isaksj.backend.model.UserSettings;

@Repository
public interface UserSettingsRepository extends JpaRepository<UserSettings, Long> {
    UserSettings findById(long id);

    UserSettings findByUser(User user);
}

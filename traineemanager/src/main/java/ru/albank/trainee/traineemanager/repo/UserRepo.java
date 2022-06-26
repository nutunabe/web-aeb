package ru.albank.trainee.traineemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.albank.trainee.traineemanager.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

package ru.albank.trainee.traineemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.albank.trainee.traineemanager.models.Resume;

import java.util.Optional;

public interface ResumeRepo extends JpaRepository<Resume, Long> {

    Optional<Resume> findResumeById(Long id);

    void deleteResumeById(Long id);
}

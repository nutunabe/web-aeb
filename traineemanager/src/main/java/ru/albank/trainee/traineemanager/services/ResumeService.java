package ru.albank.trainee.traineemanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.albank.trainee.traineemanager.exceptions.IdNotFoundException;
import ru.albank.trainee.traineemanager.models.Resume;
import ru.albank.trainee.traineemanager.repo.ResumeRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResumeService {
    private final ResumeRepo resumeRepo;

    @Autowired
    public ResumeService(ResumeRepo resumeRepo) {
        this.resumeRepo = resumeRepo;
    }

    public List<Resume> findAllResumes() {
        return resumeRepo.findAll();
    }

    public Resume findResumeById(Long id) {
        return resumeRepo.findResumeById(id)
                .orElseThrow(() -> new IdNotFoundException("Resume by id " + id + " was not found"));
    }

    public Resume addResume(Resume resume) {
        return resumeRepo.save(resume);
    }

    public Resume updateResume(Resume resume) {
        return resumeRepo.save(resume);
    }

    public void deleteResume(Long id) {
        resumeRepo.deleteResumeById(id);
    }
}

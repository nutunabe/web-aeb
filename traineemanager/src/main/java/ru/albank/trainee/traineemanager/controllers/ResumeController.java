package ru.albank.trainee.traineemanager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.albank.trainee.traineemanager.models.Resume;
import ru.albank.trainee.traineemanager.services.ResumeService;

import java.util.List;

@RestController
@RequestMapping("/controllers/resume")
public class ResumeController {
    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Resume>> getAllResumes() {
        List<Resume> resumes = resumeService.findAllResumes();
        return new ResponseEntity<>(resumes, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Resume> getResumeById(@PathVariable("id") Long id) {
        Resume resume = resumeService.findResumeById(id);
        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Resume> addResume(@RequestBody Resume resume) {
        Resume newResume = resumeService.addResume(resume);
        return new ResponseEntity<>(newResume, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Resume> updateResume(@RequestBody Resume resume) {
        Resume updatedResume = resumeService.updateResume(resume);
        return new ResponseEntity<>(updatedResume, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Resume> deleteResume(@PathVariable("id") Long id) {
        resumeService.deleteResume(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

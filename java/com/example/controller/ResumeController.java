package com.example.controller;

import com.example.model.Resume;

import java.util.List;

public class ResumeController {
    private final ResumeService resumeService;

    public ResponseEntity<Resume> createResume(@RequestBody Resume resume) {
        return ResponseEntity.ok(resumeService.createResume(resume));
    }

    public ResponseEntity<Resume> updateResume(
        return ResponseEntity.ok(resumeService.updateResume(id, resume));
    }



    public ResponseEntity<Void> deleteResume(@PathVariable Long id) {
        resumeService.deleteResume(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<Resume>> getAllResumes() {
        return ResponseEntity.ok(resumeService.getAllResumes());
    }

    public ResponseEntity<List<Resume>> getResumesByCategory( {
        return ResponseEntity.ok(resumeService.getResumesByCategory(categoryId));
    }
}

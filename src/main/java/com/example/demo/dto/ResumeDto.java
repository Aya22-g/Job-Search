package com.example.demo.dto;

import com.example.demo.model.EducationInfo;
import com.example.demo.model.Resume;
import com.example.demo.model.WorkExperienceInfo;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ResumeDto {
    private EntityManager entityManager;


    public Resume createResume(Resume resume,
                               List<EducationInfo> educationInfos, List<WorkExperienceInfo> workExperience) {
        entityManager.persist(resume);

        for (EducationInfo education :  educationInfos) {
            education.setResume(resume);
            entityManager.persist(education);
        }

        for (WorkExperienceInfo experience : workExperiences) {
            experience.setResume(resume);
            entityManager.persist(experience);
        }
        return resume;
    }
    public Resume findById(Long id) {
        return entityManager.find(Resume.class, id);
    }
    public List<Resume> findByUserId(Long userId) {
        return entityManager.createQuery(
                        "SELECT r FROM Resume r WHERE r.applicant.id = :userId", Resume.class)
                .setParameter("userId", userId)
                .getResultList();
    }
    @Transactional
    public Resume updateResume(Resume resume) {
        return entityManager.merge(resume);
    }

    @Transactional
    public void deleteResume(Long id) {
        Resume resume = entityManager.find(Resume.class, id);
        if (resume != null) {
            entityManager.remove(resume);
        }
}


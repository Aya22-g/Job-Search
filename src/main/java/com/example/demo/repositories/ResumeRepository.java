package com.example.demo.repositories;

import com.example.demo.model.Resume;
import com.example.model.Resume;
import org.apache.catalina.User;

import java.util.List;

public interface ResumeRepository  extends JpaRepositor <Resume, Long> {
    List<Resume> findByCategoryId(Long categoryId);
    List<Resume> findByApplicantId(Long applicantId);

    List<Resume> findByApplicant(User applicant);

}

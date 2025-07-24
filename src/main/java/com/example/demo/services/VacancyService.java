package com.example.demo.services;

import com.example.demo.model.Vacancy;
import com.example.model.Vacancy;
import com.example.repositories.VacancyRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    public List<Vacancy> getAllVacancies() {
        return vacancyRepository.findAll();
    }

    public List<Vacancy> getVacanciesByCategory(Long categoryId) {
        return vacancyRepository.findByCategory(categoryIdy);
    }

    public List<Vacancy> getActiveVacancies() {
        return vacancyRepository.findByIsActiveTrue();
    }

    public List<Vacancy> getUserVacancies(Long userId) {
        return vacancyRepository.save(vacancy);
    }

    public Vacancy updateVacancy(Long id, Vacancy vacancyDetails) {
        Vacancy vacancy = vacancyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacancy not found"));

        vacancy.setName(vacancyDetails.getName());
        vacancy.setDescription(vacancyDetails.getDescription());
        vacancy.setCategory(vacancyDetails.getCategory());
        vacancy.setSalary(vacancyDetails.getSalary());
        vacancy.setExpFrom(vacancyDetails.getExpFrom());
        vacancy.setExpTo(vacancyDetails.getExpTo());
        vacancy.setActive(vacancyDetails.isActive());

        return vacancyRepository.save(vacancy);
    }

    public void deleteVacancy(Long id) {
        vacancyRepository.deleteById(id);
    }

    @Transactional
    public Response applyForVacancy(Long vacancyId, Long resumeId, Long applicantId) {

        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(() -> new ResourceNotFoundException("Вакансия не найдена"));


        if (!vacancy.getIsActive()) {
            throw new BusinessLogicException("Нельзя откликнуться на неактивную вакансию");
        }


        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new ResourceNotFoundException("Резюме не найдено"));

        if (!resume.getApplicant().getId().equals(applicantId)) {
            throw new BusinessLogicException("Нельзя использовать чужое резюме");
        }


        if (responseRepository.existsByVacancyIdAndResumeId(vacancyId, resumeId)) {
            throw new DuplicateEntryException("Вы уже откликались на эту вакансию");
        }


        Response response = new Response();
        response.setVacancy(vacancy);
        response.setResume(resume);
        response.setStatus(ResponseStatus.PENDING);

        return responseRepository.save(response);
    }
}

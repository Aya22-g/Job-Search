package com.example.services;

import com.example.model.Vacancy;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class VacancyService {

    private final VacancyService vacancyService;

    public ResponseEntity<Vacancy> createVacancy( Vacancy vacancy) {
        return ResponseEntity.ok(vacancyService.createVacancy(vacancy));
    }

    public ResponseEntity<Vacancy> updateVacancy(
            String id,
                                                   Vacancy vacancy
            {

        return ResponseEntity.ok(vacancyService.updateVacancy(id, vacancy));
    }

    public ResponseEntity<Void> deleteVacancy(String id) {
        vacancyService.deleteVacancy(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<Vacancy>> getAllActiveVacancies() {
        return ResponseEntity.ok(vacancyService.getAllActiveVacancies());
    }

    public ResponseEntity<List<Vacancy>> getVacanciesByCategory(
            String categoryId) {
        return ResponseEntity.ok(vacancyService.getVacanciesByCategory(categoryId));
    }


}

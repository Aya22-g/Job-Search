package com.example.controller;

public class VacancyController {
    private final VacancyService vacancyService;

    public ResponseEntity<Vacancy> createVacancy(@RequestBody Vacancy vacancy) {
        return ResponseEntity.ok(vacancyService.createVacancy(vacancy));
    }
}

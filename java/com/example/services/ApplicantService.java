package com.example.services;

public class ApplicantService {
    private final ApplicantService respondedApplicantService;


    public ResponseEntity<Applicant> respondToVacancy( {
        return ResponseEntity.ok(ApplicantService.createResponse(response));
    }

    @GetMapping("/vacancy/{vacancyId}")
    public ResponseEntity<List<RespondedApplicant>> getResponsesForVacancy(
            @PathVariable Long vacancyId) {
        return ResponseEntity.ok(
                ApplicantService.getResponsesForVacancy(vacancyId));
    }
}

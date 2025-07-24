package com.example.demo.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EducationRequest {
    @NotBlank(message = "Название учебного заведения обязательно")
    private String institution;

    @NotBlank(message = "Название программы обязательно")
    private String program;

    @PastOrPresent(message = "Дата начала должна быть в прошлом или настоящем")
    private LocalDate startDate;

    @PastOrPresent(message = "Дата окончания должна быть в прошлом или настоящем")
    private LocalDate endDate;
}

package com.example.demo.Request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResumeRequest {
    @NotBlank (message = "Название резюме не может быть пустым")
    @Size(max = 100, message = "Название резюме должно быть не длиннее 100 символов")
    private String name;

    @NotNull(message = "ID категории обязателен")
    private Long categoryId;

    @DecimalMin(value = "0.0", message = "Зарплата не может быть отрицательной")
    @DecimalMax(value = "100000.0", message = "Зарплата слишком высокая")
    private BigDecimal salary;

    @AssertTrue(message = "Резюме должно быть активным при создании")
    private Boolean isActive = true;

    @Valid
    private List<EducationRequest> educations;

    @Valid
    private List<WorkExperienceRequest> experiences;
}
}

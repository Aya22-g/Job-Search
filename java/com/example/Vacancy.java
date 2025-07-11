package com.example;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
public class Vacancy {
    private Integer id;
    private String name;
    private String description;
    private double salary;

    private Integer expFrom;
    private Integer expTo;
    private boolean isActive;
    private User author;
    private Category category;
    private LocalDateTime updatedTime;
}

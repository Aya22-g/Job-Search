package com.example;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.lang.annotation.Repeatable;
import java.time.LocalDateTime;

@Data
public class Message {
    private Integer id;
    private String content;
    private LocalDateTime timestamp;

    private RespondedApplicant respondedApplicant;
}

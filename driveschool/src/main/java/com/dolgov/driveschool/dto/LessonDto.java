package com.dolgov.driveschool.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class LessonDto {
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int price;
    private InstructorDto instructor;
    private UserDto user;
}

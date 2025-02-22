package com.dolgov.driveschool.dto;

import lombok.Data;

@Data
public class InstructorDto {
    private Long id;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String bio;
}
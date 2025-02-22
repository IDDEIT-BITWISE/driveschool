package com.dolgov.driveschool.services;

import com.dolgov.driveschool.dto.InstructorDto;
import com.dolgov.driveschool.models.Instructor;
import com.dolgov.driveschool.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public InstructorDto instructorToDto(Instructor instructor) {
        InstructorDto dto = new InstructorDto();
        dto.setId(instructor.getId());
        dto.setBio(instructor.getBio());
        dto.setFirstName(instructor.getFirstName());
        dto.setSecondName(instructor.getSecondName());
        dto.setThirdName(instructor.getThirdName());
        return dto;
    }
}

package com.dolgov.driveschool.services;

import com.dolgov.driveschool.models.Instructor;
import com.dolgov.driveschool.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository ;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> getAll() {
        return instructorRepository.findAll();
    }
}

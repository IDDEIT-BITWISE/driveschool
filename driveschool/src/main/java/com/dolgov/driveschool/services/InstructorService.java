package com.dolgov.driveschool.services;

import com.dolgov.driveschool.models.Instructor;
import com.dolgov.driveschool.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Instructor getInstructorById(Long id){
        return instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("instructor not found"));
    }
}

package com.dolgov.driveschool.controllers;

import com.dolgov.driveschool.models.Instructor;
import com.dolgov.driveschool.models.Lesson;
import com.dolgov.driveschool.services.InstructorService;
import com.dolgov.driveschool.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/schedule ")
@Controller
//@PreAuthorize("STUDENT_ROLE")
public class StudentScheduleController {
    private final LessonService lessonService;
    private final InstructorService instructorService;

    @Autowired
    public StudentScheduleController(LessonService lessonService, InstructorService instructorService) {
        this.lessonService = lessonService;
        this.instructorService = instructorService;
    }


}

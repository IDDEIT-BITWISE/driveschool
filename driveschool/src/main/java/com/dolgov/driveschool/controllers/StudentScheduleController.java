package com.dolgov.driveschool.controllers;

import com.dolgov.driveschool.dto.LessonDto;
import com.dolgov.driveschool.models.Lesson;
import com.dolgov.driveschool.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/student/schedule")
//@PreAuthorize("hasRole('STUDENT_ROLE')")
public class StudentScheduleController {
    private final LessonService lessonService;

    @Autowired
    public StudentScheduleController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/current-week")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<LessonDto>> getCurrentWeekSchedule() {
        LocalDate[] weekDates = lessonService.getCurrentWeekDates();
        LocalDate startOfWeek = weekDates[0];
        LocalDate endOfWeek = weekDates[1];

        List<Lesson> weeklySchedule = lessonService.getWeeklySchedule(startOfWeek, endOfWeek);
        List<LessonDto> lessonDtos = weeklySchedule.stream().
                map(lessonService::lessonToDto).
                collect(Collectors.toList());
        return ResponseEntity.ok(lessonDtos);


    }
}

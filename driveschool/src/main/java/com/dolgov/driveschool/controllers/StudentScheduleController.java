package com.dolgov.driveschool.controllers;

import com.dolgov.driveschool.models.Lesson;
import com.dolgov.driveschool.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

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
    public ResponseEntity<List<Lesson>> getCurrentWeekSchedule() {
        LocalDate[] weekDates = lessonService.getCurrentWeekDates();
        LocalDate startOfWeek = weekDates[0];
        LocalDate endOfWeek = weekDates[1];

        List<Lesson> weeklySchedule = lessonService.getWeeklySchedule(startOfWeek, endOfWeek);
        return ResponseEntity.ok(weeklySchedule);


    }
}

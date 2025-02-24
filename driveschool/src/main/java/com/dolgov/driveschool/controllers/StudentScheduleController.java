package com.dolgov.driveschool.controllers;

import com.dolgov.driveschool.models.Lesson;
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

@RequestMapping("/schedule/")
@Controller
//@PreAuthorize("STUDENT_ROLE")
public class StudentScheduleController {
    private final LessonService lessonService;

    @Autowired
    public StudentScheduleController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/current-week")
    public String getCurrentWeekSchedule(Model model, Authentication authentication) {
        LocalDate[] weekDates = lessonService.getCurrentWeekDates();
        LocalDate startOfWeek = weekDates[0];
        LocalDate endOfWeek = weekDates[1];

        List<Lesson> weeklySchedule = lessonService.getWeeklySchedule(startOfWeek, endOfWeek);
        model.addAttribute(weeklySchedule);
        return "schedule";
    }

    @GetMapping("/{date}")
    public String getLessonByDay(@PathVariable("date") LocalDate date, Model model) {
        List<Lesson> lessons = lessonService.getLessonsByDate(date);
        model.addAttribute(lessons);
        System.out.println("ПИЗДААААААААААААААААААААААААААААААААААААААААААААААА");
        System.out.println(lessons);
        return "scheduleStudent";
    }








}

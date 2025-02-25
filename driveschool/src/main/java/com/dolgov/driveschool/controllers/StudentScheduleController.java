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

@RequestMapping("/schedule ")
@Controller
//@PreAuthorize("STUDENT_ROLE")
public class StudentScheduleController {
    private final LessonService lessonService;

    @Autowired
    public StudentScheduleController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/{date}")
    public String getLessonByDay(@PathVariable("date") LocalDate date, Model model) {
        List<Lesson> lessons = lessonService.getLessonsByDate(date);
        model.addAttribute("lessons", lessons);
        model.addAttribute("lesson", new Lesson());
        System.out.println("getMapping /date");
        //System.out.println(lessons);
        return "schedule";
    }

    @GetMapping("/")
    public String getLessonsToday(Model model) {
        LocalDate today = lessonService.getToday();
        List<Lesson> lessons = lessonService.getLessonsByDate(today);
        model.addAttribute("lessons", lessons);
        model.addAttribute("lesson", new Lesson());
        //System.out.printf("ПИЗДААААААААААААААААААААААААААААААААААААААААААААААААААА");
        //System.out.println(lessons);
        return "schedule";
    }
}

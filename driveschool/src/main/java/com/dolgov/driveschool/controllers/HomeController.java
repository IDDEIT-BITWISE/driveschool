package com.dolgov.driveschool.controllers;

import com.dolgov.driveschool.models.Lesson;
import com.dolgov.driveschool.services.LessonService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class HomeController {

    private final LessonService lessonService;

    @Autowired
    public HomeController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/")
    public String index(){

        return "home";
    }
    @GetMapping("/{date}")
    public String getLessonByDay(@PathVariable("date") LocalDate date, Model model) {
        List<Lesson> lessons = lessonService.getLessonsByDate(date);
        //model.addAttribute(lessons);
        System.out.println("ПИЗДААААААААААААААААААААААААААААААААААААААААААААААА");
        System.out.println(lessons);
        return "/";
    }
}

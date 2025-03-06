package com.dolgov.driveschool.controllers;

import com.dolgov.driveschool.models.Instructor;
import com.dolgov.driveschool.models.Lesson;
import com.dolgov.driveschool.models.User;
import com.dolgov.driveschool.models.UserRole;
import com.dolgov.driveschool.services.InstructorService;
import com.dolgov.driveschool.services.LessonService;
import com.dolgov.driveschool.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private final LessonService lessonService;
    private final InstructorService instructorService;
    private final UserService userService;

    @Autowired
    public HomeController(LessonService lessonService, InstructorService instructorService, UserService userService) {
        this.lessonService = lessonService;
        this.instructorService = instructorService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(){

        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/courses")
    public String courses(){
        return "courses";
    }

    @GetMapping("/contacts")
    public String contacts(){
        return "contacts";
    }


}

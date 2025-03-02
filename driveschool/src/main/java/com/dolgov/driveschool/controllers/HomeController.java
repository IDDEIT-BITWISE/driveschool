package com.dolgov.driveschool.controllers;

import com.dolgov.driveschool.models.Instructor;
import com.dolgov.driveschool.models.Lesson;
import com.dolgov.driveschool.models.User;
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

    @GetMapping("/schedule")
    public String getSchedule(){
        LocalDate today = lessonService.getToday();
        return "redirect:/schedule/1/"+today.toString();
    }

    @GetMapping("/getSchedule")
    public String getLessons(
            @RequestParam(required = false, defaultValue = "1") Long instructorId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate datePicker
    ) {
        if (datePicker == null) {
            datePicker = LocalDate.now();
        }
        String resRedir = "redirect:/schedule/" + instructorId + "/" + datePicker;
        return resRedir;
    }

    @GetMapping("/schedule/{instructorId}/{date}")
    public String getLessonsToday(@PathVariable("instructorId") Long instructorId,@PathVariable("date") LocalDate date, Model model) {
        Instructor currentInstructor = instructorService.getInstructorById(instructorId);

        List<Lesson> lessons = lessonService.getAllByInstructorAndDate(instructorId, date);
        model.addAttribute("lessons", lessons);
        model.addAttribute("lesson", new Lesson());

        model.addAttribute("instructors", instructorService.getAll());
        model.addAttribute("instructor", new Instructor());
        model.addAttribute("currentInstructor", currentInstructor);
        model.addAttribute("datePicker",date);

        return "schedule";
    }

    @GetMapping("/schedule/signup/{id}")
    public String signUpLesson(@PathVariable("id") Long lessonId, Authentication authentication) {
        String username = authentication.getName();
        User user = userService.getUserByName(username);
        Long userId = user.getId();
        lessonService.joinLesson(userId, lessonId);
        return "home";
    }

    @GetMapping(value = "/register")
    public String goRegister() {
        return "register";
    }

}

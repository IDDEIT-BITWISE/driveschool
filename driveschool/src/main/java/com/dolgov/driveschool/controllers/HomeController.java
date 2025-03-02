package com.dolgov.driveschool.controllers;

import com.dolgov.driveschool.models.Instructor;
import com.dolgov.driveschool.models.Lesson;
import com.dolgov.driveschool.services.InstructorService;
import com.dolgov.driveschool.services.LessonService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public HomeController(LessonService lessonService, InstructorService instructorService) {
        this.lessonService = lessonService;
        this.instructorService = instructorService;
    }

    @GetMapping("/")
    public String index(){

        return "home";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/schedule")
    public String getSchedule(){
        LocalDate today = lessonService.getToday();
        return "redirect:/schedule/1/"+today.toString();
    }

    @PostMapping("/getSchedule")
    public String getLessons(@RequestParam Long instructorId, @RequestParam LocalDate datePicker) {
        String resRedir = "redirect:/schedule/"+instructorId.toString() + "/" + datePicker.toString();
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
    public String signUpLesson(@PathVariable("id") Long id) {

        return "home";
    }

    @GetMapping(value = "/register")
    public String goRegister() {
        return "register";
    }

}

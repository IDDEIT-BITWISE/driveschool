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

    @GetMapping("/schedule/{instructorId}/{date}/saveLesson")
    public String saveLesson(@PathVariable("instructorId") Long instructorId,
                             @PathVariable("date") LocalDate date,
                             @RequestParam(required = true) String timeSelect) {
        LocalTime lessonTime = LocalTime.parse(timeSelect);
        Lesson lesson = new Lesson();
        lesson.setTime(lessonTime);
        lesson.setInstructor(instructorService.getInstructorById(instructorId));
        lesson.setDate(date);
        if(!lessonService.isLessonTimeExist(instructorId, date, lessonTime)){
            lessonService.saveLesson(lesson);
        }

        return "redirect:/schedule/" + instructorId + "/" + date;

    }

    @GetMapping("/schedule/{instructorId}/{date}")
    public String getLessonsToday(@PathVariable("instructorId") Long instructorId,@PathVariable("date") LocalDate date, Model model, Authentication authentication) {
        if (LocalDate.now().isAfter(date)) {
            return "redirect:/schedule";
        }
        else {
            Instructor currentInstructor = instructorService.getInstructorById(instructorId);
            String URI = "/schedule/"+String.valueOf(instructorId)+"/"+String.valueOf(date);
            model.addAttribute("URI", URI);

            List<Lesson> lessons = lessonService.getAllByInstructorAndDate(instructorId, date);
            model.addAttribute("lessons", lessons);
            model.addAttribute("lesson", new Lesson());

            model.addAttribute("instructors", instructorService.getAll());
            model.addAttribute("instructor", new Instructor());
            model.addAttribute("currentInstructor", currentInstructor);
            model.addAttribute("datePicker",date);
            System.out.println(authentication.getAuthorities());
            return "schedule";
            }
    }

    @GetMapping("/schedule/signup/{id}")
    public String signUpLesson(@PathVariable("id") Long lessonId, Authentication authentication) {
        String username = authentication.getName();
        User user = userService.getUserByName(username);
        Long userId = user.getId();
        lessonService.joinLesson(userId, lessonId);
        Lesson lesson = lessonService.getById(lessonId);
        Long instructorId = lesson.getInstructor().getId();
        LocalDate date = lesson.getDate();

        return "redirect:/schedule/" + instructorId + "/" + date;
    }

    @GetMapping(value = "/register")
    public String goRegister() {
        return "register";
    }

    @GetMapping("/schedule/signout/{id}")
    public String signOutLesson(
            @PathVariable("id") Long lessonId,
            Authentication authentication
    ) {
        Lesson lesson = lessonService.getById(lessonId);

        if (lesson.getDate().isEqual(LocalDate.now())) {
            return "redirect:/schedule/" + lesson.getInstructor().getId() + "/" + lesson.getDate() + "?error=today";
        }

        lessonService.signOutLesson(lessonId);

        Long instructorId = lesson.getInstructor().getId();
        LocalDate date = lesson.getDate();

        return "redirect:/schedule/" + instructorId + "/" + date;
    }

    @GetMapping("/schedule/delete/{id}")
    public String deleteLesson(@PathVariable("id") Long id, Authentication authentication) {
        Lesson lesson = lessonService.getById(id);
        lessonService.deleteLesson(lesson);
        Long instructorId = lesson.getInstructor().getId();
        LocalDate date = lesson.getDate();
        return "redirect:/schedule/"+instructorId+"/"+date;
    }
}

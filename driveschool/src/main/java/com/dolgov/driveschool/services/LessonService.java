package com.dolgov.driveschool.services;

import com.dolgov.driveschool.dto.LessonDto;
import com.dolgov.driveschool.models.Lesson;
import com.dolgov.driveschool.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    private final UserService userService;
    private final InstructorService instructorService;

    @Autowired
    public LessonService(LessonRepository lessonRepository, UserService userService, InstructorService instructorService) {
        this.lessonRepository = lessonRepository;
        this.userService = userService;
        this.instructorService = instructorService;
    }

    public LocalDate[] getCurrentWeekDates() {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)); // Понедельник
        LocalDate endOfWeek = startOfWeek.plusDays(6); // Воскресенье
        return new LocalDate[]{startOfWeek, endOfWeek};
    }

    public List<Lesson> getWeeklySchedule(LocalDate startDate, LocalDate endDate) {
        return lessonRepository.findByDateBetween(startDate, endDate);
    }

    public LessonDto lessonToDto(Lesson lesson) {
        LessonDto dto = new LessonDto();

        dto.setId(lesson.getId());
        dto.setDate(lesson.getDate());
        dto.setStartTime(lesson.getStartTime());
        dto.setEndTime(lesson.getEndTime());
        dto.setPrice(lesson.getPrice());

        if (lesson.getInstructor() != null) {
            dto.setInstructor(instructorService.instructorToDto(lesson.getInstructor()));
        }

        if (lesson.getUser() != null) {
            dto.setUser(userService.userToDto(lesson.getUser()));
        }

        return dto;
    }
}

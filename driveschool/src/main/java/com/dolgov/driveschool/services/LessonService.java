package com.dolgov.driveschool.services;

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

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
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

    public List<Lesson> getLessonsByDate(LocalDate date) {
        List<Lesson> lessons = lessonRepository.findAllByDate(date);
        return lessons;
    }

    public LocalDate getToday() {
        return LocalDate.now();
    }

    public LocalDate nextDay(LocalDate date) {
        return date.plusDays(1);
    }

    public List<Lesson> getAllByUserId(Long id) {
        return lessonRepository.findAllByUserId(id);
    }

    public List<Lesson> getAllByInstructorId(Long id) {
        return lessonRepository.findAllByInstructorId(id);
    }

    public List<Lesson> getAllByInstructorAndDate(Long instructorId, LocalDate date) {
        return lessonRepository.findAllByDateAndInstructorId(instructorId, date);
    }


}

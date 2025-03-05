package com.dolgov.driveschool.services;

import com.dolgov.driveschool.models.Lesson;
import com.dolgov.driveschool.models.User;
import com.dolgov.driveschool.repositories.LessonRepository;
import com.dolgov.driveschool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    private final UserRepository userRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository, UserService userService, UserRepository userRepository) {
        this.lessonRepository = lessonRepository;
        this.userRepository = userRepository;
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

    public void joinLesson(Long userId, Long lessonId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found"));
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("lesson not found"));
        if (lesson.getUser() != null) {
            throw new RuntimeException("lesson has user");
        }
        lesson.setUser(user);

        lessonRepository.save(lesson);
    }

    public Lesson getById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("lesson not found"));
    }

    public void signOutLesson(Long lessonId) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("user not found"));
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("lesson not found"));
        lesson.setUser(null);

        lessonRepository.save(lesson);

    }

    public void deleteLesson(Lesson lesson) {
        lessonRepository.delete(lesson);

    }



}

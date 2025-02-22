package com.dolgov.driveschool.repositories;

import com.dolgov.driveschool.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByDateBetween(LocalDate startDate, LocalDate endDate);
}

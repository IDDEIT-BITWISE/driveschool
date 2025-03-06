package com.dolgov.driveschool.repositories;

import com.dolgov.driveschool.models.Instructor;
import com.dolgov.driveschool.models.Lesson;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Lesson> findAllByDate(LocalDate date);

    List<Lesson> findAllByUserId(Long id);

    List<Lesson> findAllByInstructorId(Long id);

    @Query("SELECT p from Lesson p WHERE p.instructor.id = :instructor_id AND p.date = :date AND p.time = :time")
    Lesson findLessonByDateAndInstructorIdAndTime(@Param("instructor_id") Long instructorId,
                                                        @Param("date") LocalDate date,
                                                        @Param("time") LocalTime time);

    @Query("SELECT p from Lesson p WHERE p.instructor.id = :instructor_id AND p.date = :date")
    List<Lesson> findAllByDateAndInstructorId(@Param("instructor_id") Long instructorId, @Param("date") LocalDate date);
}

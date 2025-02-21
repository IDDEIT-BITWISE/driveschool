package com.dolgov.driveschool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "lesson")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private LocalDate date;

    @Column
    private int price;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;



    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

}

package com.dolgov.driveschool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;
    @Column
    private String secondName;
    @Column
    private String thirdName;

    @Column
    private String bio;

    @OneToMany
    @JoinColumn(name = "lesson_id")
    private List<Lesson> lessons;
}

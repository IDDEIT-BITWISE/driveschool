package com.dolgov.driveschool.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "instructors")
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

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

}

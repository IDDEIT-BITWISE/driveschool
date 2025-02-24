package com.dolgov.driveschool.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cars")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String licensePlate;

    @Column
    private String name;


}

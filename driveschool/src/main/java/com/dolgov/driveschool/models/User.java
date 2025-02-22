package com.dolgov.driveschool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private int balance;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar")
    private UserRole userRole;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Lesson> lessons = new ArrayList<>();

}

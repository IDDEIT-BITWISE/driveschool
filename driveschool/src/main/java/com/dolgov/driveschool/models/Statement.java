package com.dolgov.driveschool.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "statements")
@Data
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String phone;


}

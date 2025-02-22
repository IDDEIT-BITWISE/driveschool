package com.dolgov.driveschool.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private int balance;
    private String userRole;
}

package com.dolgov.driveschool.services;

import com.dolgov.driveschool.dto.UserDto;
import com.dolgov.driveschool.models.User;
import com.dolgov.driveschool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto userToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUserRole(String.valueOf(user.getUserRole()));
        dto.setBalance(user.getBalance());
        dto.setUsername(user.getUsername());

        return dto;
    }


}

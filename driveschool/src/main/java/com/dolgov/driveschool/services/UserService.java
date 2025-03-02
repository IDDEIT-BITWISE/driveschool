package com.dolgov.driveschool.services;

import com.dolgov.driveschool.models.User;
import com.dolgov.driveschool.models.UserRole;
import com.dolgov.driveschool.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("user not found"));
        return user;
    }

    public User getUserByName(String name){
        return userRepository.findByUsername(name)
                .orElseThrow(() -> new RuntimeException("user not found"));
    }

    @Transactional
    public void save(User user) {
        user.setUserRole(UserRole.STUDENT_ROLE);
        user.setPassword("{noop}"+user.getPassword());
        userRepository.save(user);
    }

}

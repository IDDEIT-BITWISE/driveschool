package com.dolgov.driveschool.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

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

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar")
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private List<Lesson> lessons = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(String.valueOf(this.userRole.name()));
    }


}

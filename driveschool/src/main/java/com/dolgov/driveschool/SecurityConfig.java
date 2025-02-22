package com.dolgov.driveschool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(auth ->auth
                        .requestMatchers("/**").permitAll()
                        //.requestMatchers("/student/schedule").hasAnyAuthority("STUDENT_ROLE")
                        .requestMatchers("/admin/schedule").hasAnyAuthority("ADMIN_ROLE")
                        .anyRequest().authenticated()
                )
                ;
//                .formLogin(login -> login
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/")
//                        .failureUrl("/login?error=true")
//                        .usernameParameter("email")
//                        .permitAll())
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/login?logout=true")
//                        .deleteCookies("JSESSIONID"));
        return http.build();
    }
}


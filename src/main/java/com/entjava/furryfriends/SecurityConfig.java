package com.entjava.furryfriends;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .anyRequest().authenticated() // Require authentication for all requests
                )
                .httpBasic(withDefaults()); // Enable Basic Authentication

        return http.build();
    } // POJO plain old java objects

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails renzo = User
                .withDefaultPasswordEncoder()
                .username("renzo")
                .password("reyes")
                .roles("USER")
                .build();

        UserDetails james = User
                .withDefaultPasswordEncoder()
                .username("james")
                .password("baquirin")
                .roles("USER")
                .build();

        UserDetails justine = User
                .withDefaultPasswordEncoder()
                .username("justine")
                .password("hernandez")
                .roles("USER")
                .build();

        UserDetails omar = User
                .withDefaultPasswordEncoder()
                .username("oms")
                .password("pogiko123")
                .roles("USER")
                .build();

        UserDetails arwen = User
                .withDefaultPasswordEncoder()
                .username("wen")
                .password("thankubeyonce")
                .roles("USER")
                .build();

        UserDetails roman = User
                .withDefaultPasswordEncoder()
                .username("roman")
                .password("albania")
                .roles("USER")
                .build();

        UserDetails anthony = User
                .withDefaultPasswordEncoder()
                .username("anthony")
                .password("chan")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(renzo,james,justine,omar,arwen,roman,anthony);
    }
}

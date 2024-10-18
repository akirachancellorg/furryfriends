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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

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
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        List<UserDetails> users = new ArrayList<>();

        // Add users to the list
        users.add(User.withUsername("mon")
                .password(passwordEncoder.encode("password1"))
                .roles("USER")
                .build());

        users.add(User.withUsername("danz")
                .password(passwordEncoder.encode("password2"))
                .roles("USER")
                .build());

        users.add(User.withUsername("ed")
                .password(passwordEncoder.encode("password3"))
                .roles("USER")
                .build());

        users.add(User.withUsername("kai")
                .password(passwordEncoder.encode("password4"))
                .roles("USER")
                .build());

        users.add(User.withUsername("vinz")
                .password(passwordEncoder.encode("password5"))
                .roles("USER")
                .build());

        users.add(User.withUsername("jm")
                .password(passwordEncoder.encode("password6"))
                .roles("USER")
                .build());

        users.add(User.withUsername("liam")
                .password(passwordEncoder.encode("password7"))
                .roles("USER")
                .build());

        users.add(User.withUsername("ken")
                .password(passwordEncoder.encode("password8"))
                .roles("USER")
                .build());


        // Return the InMemoryUserDetailsManager with the list of users
        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCryptPasswordEncoder for better security
    }
}

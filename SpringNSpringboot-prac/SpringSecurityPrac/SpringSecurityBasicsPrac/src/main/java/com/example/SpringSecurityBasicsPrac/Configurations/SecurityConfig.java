package com.example.SpringSecurityBasicsPrac.Configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 1. CSRF DISABLE
    //         - SAME SITE STRICT
    //         - STATELESS SESSIONS
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(customizer -> customizer.disable())
                    .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                        .formLogin(Customizer.withDefaults()) // remove or comment .formLogin while using STATELESS SESSION to avoid Continuous Login Issue
                            .httpBasic(Customizer.withDefaults())
                                .sessionManagement(session ->
                                                      session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                    .build();
    }


    @Bean
    public UserDetailsService userDetailsService() {

        List<UserDetails> users = new ArrayList<>();

        UserDetails user1 = User.withDefaultPasswordEncoder()
                                .username("Suman")
                                    .password("212")
                                        .roles("USER")
                                            .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("Rajest")
                .password("12")
                .roles("USER")
                .build();

        UserDetails user3 = User.withDefaultPasswordEncoder()
                .username("Kuja")
                .password("111")
                .roles("USER")
                .build();

        users.add(user1);
        users.add(user2);
        users.add(user3);

//      Collections
        return new InMemoryUserDetailsManager(users);

//        Var Args Methods
//        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
}

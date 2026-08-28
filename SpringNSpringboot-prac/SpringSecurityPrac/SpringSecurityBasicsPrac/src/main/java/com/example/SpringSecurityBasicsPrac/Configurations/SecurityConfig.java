package com.example.SpringSecurityBasicsPrac.Configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

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
}

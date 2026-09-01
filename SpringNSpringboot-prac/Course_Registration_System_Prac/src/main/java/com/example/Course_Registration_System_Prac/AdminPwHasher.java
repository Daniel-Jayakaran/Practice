package com.example.Course_Registration_System_Prac;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AdminPwHasher {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
        String plaintext = "Admin123";
        String hashedPW = encoder.encode(plaintext);
        System.out.println(hashedPW);
    }
}

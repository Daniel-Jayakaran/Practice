package com.example.SpringSecurityBasicsPrac;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    public static void main(String args[]){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
        String plaintext = "admin1234";
        String hashedPw = encoder.encode(plaintext);
        System.out.println(hashedPw);
    }
}

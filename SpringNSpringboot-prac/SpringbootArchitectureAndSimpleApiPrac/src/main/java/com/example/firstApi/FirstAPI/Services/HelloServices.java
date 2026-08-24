package com.example.firstApi.FirstAPI.Services;

import org.springframework.stereotype.Service;

@Service
public class HelloServices {

    public HelloServices() {
        System.out.println("Hello Service Constructor Called");
    }

    public String greet() {
        return "This is Starting Greetings";
    }
}

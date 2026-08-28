package com.example.SpringSecurityBasicsPrac.Controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String home(HttpServletRequest request) {
        return "Welcome to Home Page! - Session ID: " + request.getSession().getId() ;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/about")
    public String about() {
        return "Care to contact us, that why this about page exists!";
    }
}
